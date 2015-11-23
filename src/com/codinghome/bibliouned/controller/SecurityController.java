package com.codinghome.bibliouned.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Usuario o contraseña incorrecto.");
		}

		if (logout != null) {
			model.addObject("msg", "Su sesión se ha cerrado correctamente.");
		}
		model.setViewName("login");
		return model;
	}
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();	
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;
	}
	
	@RequestMapping(value = "/navigation", method = RequestMethod.GET)
	public ModelAndView navigationBar(@RequestParam(value="mainPage",required=false) String mainPage){
		ModelAndView model = new ModelAndView("navigation");
		if ("alta".equals(mainPage)){
			model.addObject("active", "alta");
		}
		else if ("consulta-usuarios".equals(mainPage)){
			model.addObject("active", "consulta-usuarios");
		}
		return model;
	}
}
