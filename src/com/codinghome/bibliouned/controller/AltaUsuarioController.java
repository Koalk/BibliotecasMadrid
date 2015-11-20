package com.codinghome.bibliouned.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.service.AltaUsuarioService;

@Controller
@RequestMapping("/")
public class AltaUsuarioController {
	
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
	
    @RequestMapping(value = { "/alta**" }, method = RequestMethod.GET)
    public ModelAndView newEmployee(final HttpServletRequest request, Principal principal) {
    	ModelAndView model = new ModelAndView("alta");
    	UsuarioExterno usuarioExterno = altaUsuarioService.getNewUsuarioExterno(sessionFactory.openSession(),principal.getName());
    	model.addObject("externalUser",usuarioExterno);
        return model;
    }
    
	@RequestMapping(value = { "/newUsuarioExterno" }, method = RequestMethod.POST)
    public ModelAndView saveUsuarioExterno(UsuarioExterno usuarioExterno) {
		Session session = this.sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
    	altaUsuarioService.persist(session,usuarioExterno);
    	tx.commit();
    	session.close();
    	
    	ModelAndView model = new ModelAndView("alta");
    	model.addObject("identificador","asdfzxcv");
    	model.setViewName("consulta-usuarios");
        return model;
    }

}
