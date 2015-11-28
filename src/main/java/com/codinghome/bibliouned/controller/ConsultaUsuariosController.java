package com.codinghome.bibliouned.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.service.ConsultaUsuariosService;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Controller
@RequestMapping("/consulta-usuarios")
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

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView externalUserView(@RequestParam(value = "userIdentificador", required = false)String identificador, final HttpServletRequest request, Principal principal) {
		ModelAndView model = null;
		Session session = sessionFactory.openSession();
		try {
			model = new ModelAndView("consulta-usuarios");
			UsuarioExternoView usuarioExterno = new UsuarioExternoView();
			if (identificador != null){
				usuarioExterno.setIdentificador(identificador);
				List<UsuarioExterno> usuariosExternos =  consultaUsuariosService.findUsuariosExternos(sessionFactory.openSession(), usuarioExterno);
				model.addObject("usuariosExternos",usuariosExternos);
			}
			model.addObject("externalUser",usuarioExterno);
		} finally {
			session.close();
		}
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView searchExternalUsers(@ModelAttribute("externalUser") UsuarioExternoView usuarioExterno, BindingResult result) {
		ModelAndView model = null;
		Session session = sessionFactory.openSession();
		try {
			model = new ModelAndView();
			model.addObject("externalUser",usuarioExterno);
			List<UsuarioExterno> usuariosExternos =  consultaUsuariosService.findUsuariosExternos(session, usuarioExterno);
			//		for (UsuarioExterno user: usuariosExternos) {
			//			System.out.println(user.getNombre());
			//			System.out.println(user.getApellido1());
			//			System.out.println(user.getApellido2());
			//			System.out.println(user.getIdentificador());
			//			System.out.println(user.getNifPasaporte());
			//			System.out.println(user.getTelefono());
			//			System.out.println(user.getMail());
			//			System.out.println(user.getLocalidad());
			//		}
			model.addObject("usuariosExternos",usuariosExternos);
		} finally {
			session.close();
		}
		return model;
	}
}
