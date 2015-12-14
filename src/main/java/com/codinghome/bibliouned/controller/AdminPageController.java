package com.codinghome.bibliouned.controller;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.service.UserService;
import com.codinghome.bibliouned.util.ViewUtil;
import com.codinghome.bibliouned.view.UsuarioView;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private ViewUtil viewUtil;
	public void setViewUtil(ViewUtil viewUtil) {
		this.viewUtil = viewUtil;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminMenu(){
		Session session = sessionFactory.openSession();
		ModelAndView model = null;
		try {
			model = new ModelAndView("admin-menu");
			List<UsuarioView> usuarioViewList = userService.getUsuarios(session);
			model.addObject("usuarioViewList",usuarioViewList);
		} finally {
			session.close();
		}
		return model;
	}

	@RequestMapping(value = "newuser", method = RequestMethod.GET)
	public ModelAndView getNewUser(@RequestParam(value = "userIdentificador", required = false)String identificador, final HttpServletRequest request, Principal principal) {
		ModelAndView model = null;
		Session session = sessionFactory.openSession();		
		try {
			model = new ModelAndView("admin-user");
			UsuarioView usuarioView = null;
			if (identificador == null){
				usuarioView = new UsuarioView();
			}
			else {
				usuarioView = userService.getUsuarioViewById(session, identificador);
			}
			model.addObject("usuarioView",usuarioView);
		} finally {
			session.close();
		}
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addNewUser(final HttpServletRequest request, 
			Principal principal, 
			@Valid @ModelAttribute(value = "userView") UsuarioView userView, 
			BindingResult result){
		ModelAndView model = new ModelAndView();
		if (!result.hasErrors()){
			Session session = this.sessionFactory.openSession();
			try {
				UsuarioView oldUser = userService.getUsuarioViewById(session, userView.getUsuario());
				validateUsuario(session,userView,oldUser,result);
				if (!result.hasErrors()){
					BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
					if (userView.getNewPassword() != null){
						userView.setNewPassword(encoder.encode(userView.getNewPassword()));
					}
					Transaction tx = session.beginTransaction();
					Usuario usuario = viewUtil.getUsuarioFromView(session, (oldUser != null ? oldUser.getUsuario() : null), userView, true);
					usuario.setPassword(userView.getNewPassword() != null ? userView.getNewPassword() : oldUser.getPassword());
					userService.addUsuario(session,usuario);
					tx.commit();
					model.setViewName("redirect:admin-menu");
				}
			} finally {
				session.close();
			}
		}
		return model;
	}

	private void validateUsuario(Session session, UsuarioView user, UsuarioView oldUser, BindingResult errorData) {
		if (oldUser != null && !user.getUsuario().equals(oldUser.getUsuario()) &&
				userService.isDuplicatedUserName(session, user.getUsuario())){
			ObjectError error = new ObjectError("usuario","Ese usuario ya existe.");
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
		else if (oldUser == null){
			ObjectError error = new ObjectError("newPassword","Debe asignar una contraseña válida.");
			errorData.addError(error);
		}
	}
}