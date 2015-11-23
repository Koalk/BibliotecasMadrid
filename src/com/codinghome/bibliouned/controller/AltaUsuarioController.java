package com.codinghome.bibliouned.controller;

import java.io.File;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView newEmployee(final HttpServletRequest request, Principal principal) {
		ModelAndView model = new ModelAndView("alta");
		UsuarioExternoView externalUser = altaUsuarioService.getNewUsuarioExterno(sessionFactory.openSession(),principal.getName());
		model.addObject("externalUser",externalUser);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveUsuarioExterno(final HttpServletRequest request, 
			Principal principal, 
			@ModelAttribute(value = "externaluser") UsuarioExternoView externalUser, 
			BindingResult result) {
		Map<String,String> errors = validateUsuarioExterno(externalUser);
		MultipartFile foto = externalUser.getFoto();
		if (foto == null || foto.isEmpty() || validateImage(foto)){
			errors.put("errorfoto", "Es obligatorio añadir una foto.");
		}
		ModelAndView model = new ModelAndView("consulta-usuarios");
		String pathFoto = null;
		if (errors.isEmpty() && (pathFoto = saveImage(externalUser.getNifPasaporte() + ".jpg", foto, errors)) != null){
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			UsuarioExterno usuarioExterno = altaUsuarioService.getUsuarioExternoFromView(session, principal.getName(), externalUser);
			usuarioExterno.setFoto(pathFoto);
			altaUsuarioService.persist(session,usuarioExterno);
			tx.commit();
			session.close();
			model.addObject("identificador",externalUser.getIdentificador());
		}
		else {
			model.addObject("externalUser",externalUser);
			model.setViewName("alta");
			model.addAllObjects(errors);
		}
		//		System.out.println(usuarioExterno.getFoto().getSize());

		return model;
	}

	private String saveImage(String fileName, MultipartFile image, Map<String, String> errors) {
		String result = null;
		try {
			File file = new File(servletContext.getRealPath("/") + "/fotos/" + fileName);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			result = file.toString();
			System.out.println("Go to the location:  " + file.toString()
					+ " on your computer and verify that the image has been stored.");
		} catch (Exception e) {
			log.error(e);
			errors.put("errorfoto", "No se ha podido guardar la foto.");
		}
		return result;
	}

	private boolean validateImage(MultipartFile image) {
		boolean result = true;
		if (!image.getContentType().equals("image/jpeg")) {
			result = false;
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
