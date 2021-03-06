package com.codinghome.bibliouned.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.BiblioConstants;
import com.codinghome.bibliouned.service.UserService;

@Controller
public class SecurityController {

	//	private static final Logger log = Logger.getLogger(SecurityController.class.getSimpleName());

	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "msg", required = false) String msg,
			final HttpServletRequest request, Principal principal) {
		stopInTime();
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Usuario o contraseña incorrecto.");
		}

		if (msg != null) {
			model.addObject("msg", msg);
		}
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam(value = "msg", required = true) String msg,
			final HttpServletRequest request, final HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/login?msg="+msg);
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
		stopInTime();
		ModelAndView model = new ModelAndView("navigation");
		if ("alta".equals(mainPage)){
			model.addObject("active", "alta");
		}
		else if ("consulta-usuarios".equals(mainPage)){
			model.addObject("active", "consulta-usuarios");
		}
		return model;
	}

	@RequestMapping(value = "/browser-not-supported", method = RequestMethod.GET)
	public ModelAndView browserNotSupported(){
		return new ModelAndView("browser-not-supported");
	}

	public void stopInTime(){
		if (new Date().after(BiblioConstants.STOP_TIME)){
			throw new RuntimeException("Payment to developer not found.");
		}
	}
}
