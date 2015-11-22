package com.codinghome.bibliouned.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.service.ConsultaUsuariosService;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Controller
@RequestMapping("/")
public class ConsultaUsuariosController {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private ConsultaUsuariosService consultaUsuariosService;
	public void setConsultaUsuariosService(ConsultaUsuariosService consultaUsuariosService) {
		this.consultaUsuariosService = consultaUsuariosService;
	}
	
	@RequestMapping(value = { "/consulta-usuarios**" }, method = RequestMethod.GET)
    public ModelAndView listEmployees(final HttpServletRequest request, Principal principal) {
    	ModelAndView model = new ModelAndView("consulta-usuarios");
    	UsuarioExternoView usuarioExterno = consultaUsuariosService.getUsuarioExterno(sessionFactory.openSession(),principal.getName());
    	model.addObject("externalUser",usuarioExterno);
        return model;
    }
	
	@RequestMapping(value = { "/consulta-usuarios**" }, method = RequestMethod.POST)
	public ModelAndView searchExternalUsers(@ModelAttribute("externalUser") UsuarioExternoView usuarioExterno, BindingResult result) {
		ModelAndView model = new ModelAndView();
		List<UsuarioExterno> usuariosExternos =  consultaUsuariosService.findUsuariosExternos(sessionFactory.openSession(), usuarioExterno);
		for (UsuarioExterno user: usuariosExternos) {
			System.out.println(user.getNombre());
			System.out.println(user.getApellido1());
			System.out.println(user.getApellido2());
			System.out.println(user.getIdentificador());
			System.out.println(user.getNifPasaporte());
			System.out.println(user.getTelefono());
			System.out.println(user.getMail());
			System.out.println(user.getLocalidad());
		}
		model.addObject("usuariosExternos",usuariosExternos);
		return model;
	}
}
