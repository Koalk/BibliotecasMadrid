package com.codinghome.bibliouned.controller;

import java.io.File;
import java.io.FileInputStream;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.service.AltaUsuarioService;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Controller
@RequestMapping("/alta")
public class AltaUsuarioController implements ServletContextAware{

	private static final Logger log = Logger.getLogger(AltaUsuarioController.class.getSimpleName());

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private AltaUsuarioService altaUsuarioService;
	public void setAltaUsuarioService(AltaUsuarioService altaUsuarioService) {
		this.altaUsuarioService = altaUsuarioService;
	}

	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newEmployee(@RequestParam(value = "userIdentificador", required = false)String identificador, final HttpServletRequest request, Principal principal) {
		Session session = sessionFactory.openSession();
		ModelAndView model = null;
		try {
			model = new ModelAndView("alta");
			UsuarioExternoView externalUser = null;
			if (identificador != null){
				externalUser = altaUsuarioService.getUsuarioExternoByIdentificador(session,identificador);
			}
			else {
				externalUser = altaUsuarioService.getNewUsuarioExterno(session,principal.getName());
			}
			if (externalUser.getFoto() != null){
				externalUser.setFoto(servletContext.getContextPath()+"/alta/fotos?fotoLocation=" + externalUser.getFoto()); 
			}
			model.addObject("externalUser",externalUser);
		} finally {
			session.close();
		}
		return model;
	}

	@RequestMapping(value = "/fotos", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getFoto(@RequestParam(value="fotoLocation") String fotoLocation)  {
		byte[] data = null;
		try {
			File file = new File(servletContext.getRealPath("/") + "../../fotos/"+fotoLocation);
			FileInputStream fis = new FileInputStream(file);
			data = IOUtils.toByteArray(fis);
		} catch (Exception e) {
			log.error(e);
		}
		return data;
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveUsuarioExterno(final HttpServletRequest request, 
			Principal principal, 
			@ModelAttribute(value = "externalUser") UsuarioExternoView externalUser, 
			BindingResult result) {
		Session session = this.sessionFactory.openSession();
		ModelAndView model = null;
		try {
			Map<String,String> errors = validateUsuarioExterno(externalUser);
			byte[] foto = null;
			if (externalUser.getFoto() == null || (foto = Base64.decode(externalUser.getFoto().getBytes())) == null || foto.length <= 0){
				errors.put("errorfoto", "Es obligatorio añadir una foto.");
			}
			model = new ModelAndView();
			String pathFoto = null;
			if (errors.isEmpty() && (pathFoto = saveImage(externalUser.getNifPasaporte() + ".jpg", foto, errors)) != null){
				Transaction tx = session.beginTransaction();
				UsuarioExterno usuarioExterno = altaUsuarioService.getUsuarioExternoFromView(session, principal.getName(), externalUser);
				usuarioExterno.setFoto(pathFoto);
				altaUsuarioService.persist(session,usuarioExterno);
				tx.commit();
				model.setViewName("redirect:consulta-usuarios?userIdentificador="+usuarioExterno.getIdentificador());
			}
			else {
				model.addObject("externalUser",externalUser);
				model.setViewName("alta");
				model.addAllObjects(errors);
			}
		} finally {
			session.close();
		}
		return model;
	}

	private String saveImage(String fileName, byte[] image, Map<String, String> errors) {
		String result = null;
		try {
			File file = new File(servletContext.getRealPath("/") + "/../../fotos/" + fileName);
			FileUtils.writeByteArrayToFile(file, image);
			result = fileName;
			System.out.println("Go to the location:  " + file.toString()
					+ " on your computer and verify that the image has been stored.");
		} catch (Exception e) {
			log.error(e);
			errors.put("errorfoto", "No se ha podido guardar la foto.");
		}
		return result;
	}

	private Map<String,String> validateUsuarioExterno(UsuarioExternoView usuarioExterno) {
		Map<String,String> errors = new HashMap<>();
		if (usuarioExterno.getNombre() == null || usuarioExterno.getNombre().isEmpty()){
			errors.put("errornombre","Campo obligatorio");
		}
		if (usuarioExterno.getApellido1() == null || usuarioExterno.getApellido1().isEmpty()){
			errors.put("errorapellido1","Campo obligatorio");
		}
		if (usuarioExterno.getNifPasaporte() == null){
			errors.put("errornifPasaporte","Campo obligatorio");
		}
		if (usuarioExterno.getFoto() == null){
			errors.put("errorfoto","Campo obligatorio");
		}
		if (!validateCodigoPostal(usuarioExterno.getCodigoPostal())){
			errors.put("errorcodigoPostal","Valor incorrecto");
		}
		if (!validateMail(usuarioExterno.getMail())){
			errors.put("errormail","Valor incorrecto");
		}
		return errors;
	}

	private boolean validateCodigoPostal(String codigoPostal) {
		Boolean result = false;
		if (codigoPostal != null && codigoPostal.length() == 5){
			try {
				Integer num = Integer.parseInt(codigoPostal);
				if (num < 52999 && num > 1001){
					result = true;
				}
			}
			catch (NumberFormatException e){}
		}
		else if (codigoPostal == null || codigoPostal.isEmpty()){
			result = true;
		}
		return result;
	}

	private boolean validateMail(String mail) {
		Pattern pattern = Pattern.compile("^([_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-\\+]+)*@"
				+ "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,5})?$");
		Matcher matcher = pattern.matcher(mail); 
		return matcher.matches();
	}

}
