package com.codinghome.bibliouned.controller;

import java.io.File;
import java.io.FileInputStream;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newExternalUser(@RequestParam(value = "userIdentificador", required = false)String identificador, final HttpServletRequest request, Principal principal) {
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
	public ModelAndView saveExternalUser(final HttpServletRequest request, 
			Principal principal, 
			@Valid @ModelAttribute(value = "externalUser") UsuarioExternoView externalUser, 
			BindingResult result) {
		ModelAndView model = null;
		if (!result.hasErrors()){
			Session session = this.sessionFactory.openSession();
			try {
				byte[] foto = null;
				if (externalUser.getFoto() == null || (foto = Base64.decode(externalUser.getFoto().getBytes())) == null || foto.length <= 0){
					ObjectError error = new ObjectError("foto", "Es obligatorio añadir una foto.");
					result.addError(error);
				}
				model = new ModelAndView();
				String pathFoto = null;
				if ((pathFoto = saveImage(externalUser.getNifPasaporte() + ".jpg", foto, result)) != null){
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
				}
			} finally {
				session.close();
			}
		}
		else {
			model = new ModelAndView();
			model.addObject("externalUser",externalUser);
			model.setViewName("alta");
		}
		return model;
	}

	private String saveImage(String fileName, byte[] image, BindingResult errorData) {
		String result = null;
		try {
			File file = new File(servletContext.getRealPath("/") + "/../../fotos/" + fileName);
			FileUtils.writeByteArrayToFile(file, image);
			result = fileName;
			System.out.println("Go to the location:  " + file.toString()
					+ " on your computer and verify that the image has been stored.");
		} catch (Exception e) {
			log.error(e);
			ObjectError error = new ObjectError("foto", "No se ha podido guardar la foto.");
			errorData.addError(error);
		}
		return result;
	}

}
