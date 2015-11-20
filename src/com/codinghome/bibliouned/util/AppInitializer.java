package com.codinghome.bibliouned.util;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codinghome.bibliouned.controller.AltaUsuarioController;
import com.codinghome.bibliouned.model.UsuarioExterno;

public class AppInitializer {
	
	public static void main( String[] args )
    {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/Spring.xml");
		Logger log = Logger.getLogger(AppInitializer.class.getSimpleName());
		
		AltaUsuarioController altaUsuarioController = appContext.getBean(AltaUsuarioController.class);
		UsuarioExterno usuarioExterno = new UsuarioExterno();
		usuarioExterno.setIdentificador("1");
		usuarioExterno.setNombre("asdf");
		log.info(altaUsuarioController.saveUsuarioExterno(usuarioExterno).toString());
		
    	appContext.close();
    	System.out.println("Done");
    }
}