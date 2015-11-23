package com.codinghome.bibliouned.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.service.ConfiguracionService;
import com.codinghome.bibliouned.view.UsuarioView;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController implements ServletContextAware{

	private static final Logger log = Logger.getLogger(ConfiguracionController.class.getSimpleName());

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private ConfiguracionService configuracionService;
	public void setConfiguracionService(ConfiguracionService configuracionService) {
		this.configuracionService = configuracionService;
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
			model = new ModelAndView("configuracion");
			UsuarioView user = null;
			if (identificador != null){
				user = configuracionService.getUsuarioByIdentificador(session,identificador);
			}
			else {
				user = configuracionService.getUsuarioByIdentificador(session,principal.getName());
			}
			model.addObject("user",user);
		} finally {
			session.close();
		}
		return model;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveUsuarioExterno(final HttpServletRequest request, 
			Principal principal, 
			@ModelAttribute(value = "user") UsuarioView user, 
			BindingResult result) {
		Session session = this.sessionFactory.openSession();
		ModelAndView model = null;
		
		try {
			Map<String,String> errors = validateUsuario(user);
			model = new ModelAndView();
			if (errors.isEmpty()){
				Transaction tx = session.beginTransaction();
				Usuario usuario = configuracionService.getUsuarioFromView(session, principal.getName(), user);
				configuracionService.persist(session,usuario);
				tx.commit();
				model.setViewName("redirect:consulta-usuarios?userIdentificador="+user.getUsuario());
			}
			else {
				model.addObject("user",user);
				model.setViewName("configuracion");
				model.addAllObjects(errors);
			}
		}
		finally {
			session.close();
		}
		
		return model;
	}

	private Map<String,String> validateUsuario(UsuarioView user) {
		Map<String,String> errors = new HashMap<>();
		if (user.getUsuario() == null || user.getUsuario().isEmpty()){
			errors.put("errorusuario","Campo obligatorio");
		}
		if (user.getPassword() == null || user.getPassword().isEmpty()){
			errors.put("errorpassword","Campo obligatorio");
		}
		else if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()){
			errors.put("errorpassword","Campo obligatorio");
		}
		else if (!user.getPassword().equals(user.getConfirmPassword())){
			errors.put("errorpassword","La contraseña no coincide");
		}
		else if (!validatePassword(user.getPassword())) {
			errors.put("errorpassword","La contraseña debe tener al menos 6 caracteres");
		}
		return errors;
	}
	
	private boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,}$");
		Matcher matcher = pattern.matcher(password); 
		return matcher.matches();
	}

}
