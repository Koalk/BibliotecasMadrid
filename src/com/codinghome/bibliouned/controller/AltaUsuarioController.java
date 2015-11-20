package com.codinghome.bibliouned.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.service.AltaUsuarioService;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Controller
@RequestMapping("/alta")
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
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView newEmployee(final HttpServletRequest request, Principal principal) {
    	ModelAndView model = new ModelAndView("alta");
    	UsuarioExternoView usuarioExterno = altaUsuarioService.getNewUsuarioExterno(sessionFactory.openSession(),principal.getName());
    	model.addObject("externalUser",usuarioExterno);
        return model;
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveUsuarioExterno(@ModelAttribute("externalUser") UsuarioExternoView usuarioExterno, BindingResult result) {
//		Session session = this.sessionFactory.openSession();
//    	Transaction tx = session.beginTransaction();
//    	altaUsuarioService.persist(session,usuarioExterno);
//    	tx.commit();
//    	session.close();
    	System.out.println(usuarioExterno.toString());
    	System.out.println(usuarioExterno.getNombre());
    	System.out.println(usuarioExterno.getApellido1());
    	System.out.println(usuarioExterno.getApellido2());
    	System.out.println(usuarioExterno.getBiblioteca());
    	System.out.println(usuarioExterno.getCodigoPostal());
    	System.out.println(usuarioExterno.getDireccion());
    	ModelAndView model = new ModelAndView("alta");
    	model.addObject("identificador","asdfzxcv");
    	model.setViewName("consulta-usuarios");
        return model;
    }

}
