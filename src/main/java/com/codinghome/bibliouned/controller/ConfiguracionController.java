package com.codinghome.bibliouned.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.service.ConfiguracionService;
import com.codinghome.bibliouned.view.UsuarioView;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {

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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getUserData(final HttpServletRequest request, Principal principal) {
		Session session = sessionFactory.openSession();
		ModelAndView model = null;
		try {
			model = new ModelAndView("configuracion");
			UsuarioView user = configuracionService.getUsuarioByIdentificador(session,principal.getName());
			user.setPassword(null);
			model.addObject("user",user);
		} finally {
			session.close();
		}
		return model;
	}


	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveUsuarioExterno(final HttpServletRequest request, 
			Principal principal, 
			@Valid @ModelAttribute(value = "user") UsuarioView user, 
			BindingResult result) {
		ModelAndView model = null;
		if (!result.hasErrors()) {
			Session session = this.sessionFactory.openSession();
			try {
				model = new ModelAndView();
				UsuarioView oldUser = configuracionService.getUsuarioByIdentificador(session, principal.getName());
				validateUsuario(session,user,oldUser,result);
				if (!result.hasErrors()){
					BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
					if (user.getNewPassword() != null){
						user.setNewPassword(encoder.encode(user.getNewPassword()));
					}
					if (user.getConfirmPassword() != null){
						user.setConfirmPassword(encoder.encode(user.getConfirmPassword()));
					}
					Transaction tx = session.beginTransaction();
					Usuario usuario = configuracionService.getUsuarioFromView(session, principal.getName(), user);
					usuario.setPassword(user.getNewPassword() != null ? user.getNewPassword() : oldUser.getPassword());
					configuracionService.persist(session,usuario);
					tx.commit();
					model.setViewName("redirect:logout?msg=Cambios en su usuario guardados correctamente.");
				}
				else {
					model.addObject("user",user);
					model.setViewName("configuracion");
				}
			}
			finally {
				session.close();
			}
		}
		else {
			model = new ModelAndView();
			model.addObject("user",user);
			model.setViewName("configuracion");
		}

		return model;
	}

	private void validateUsuario(Session session, UsuarioView user, UsuarioView oldUser, BindingResult errorData) {
		if (!user.getUsuario().equals(oldUser.getUsuario()) &&
				configuracionService.isDuplicatedUserName(session, user.getUsuario())){
			ObjectError error = new ObjectError("usuario","Ese usuario ya existe.");
			errorData.addError(error);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(user.getPassword(), oldUser.getPassword())){
			ObjectError error = new ObjectError("password","La contraseña no es correcta.");
			errorData.addError(error);
		}
		if (user.getNewPassword() != null){
			if (user.getConfirmPassword() == null){
				ObjectError error = new ObjectError("confirmPassword","Debe confirmar la nueva contraseña.");
				errorData.addError(error);
			}
			if (!user.getNewPassword().equals(user.getConfirmPassword())) {
				ObjectError error = new ObjectError("confirmPassword","No coincide con la nueva contraseña.");
				errorData.addError(error);
			}
		}
	}
}
