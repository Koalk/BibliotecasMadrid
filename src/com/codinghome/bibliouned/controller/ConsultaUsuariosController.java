package com.codinghome.bibliouned.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.service.ConsultaUsuariosService;

@Controller
@RequestMapping("/")
public class ConsultaUsuariosController {

	@Autowired
	private ConsultaUsuariosService consultaUsuariosService;
	public void setConsultaUsuariosService(ConsultaUsuariosService consultaUsuariosService) {
		this.consultaUsuariosService = consultaUsuariosService;
	}
	
	@RequestMapping(value = { "/consulta-usuarios**" }, method = RequestMethod.GET)
    public ModelAndView newEmployee() {
    	ModelAndView model = new ModelAndView("consulta-usuarios");
    	model.addObject("identificador","asdfzxcv");
        return model;
    }
}
