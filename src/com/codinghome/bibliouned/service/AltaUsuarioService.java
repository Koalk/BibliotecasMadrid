package com.codinghome.bibliouned.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.UsuarioExterno;

@Service("altaUsuarioService")
public class AltaUsuarioService {

	Logger log = Logger.getLogger(AltaUsuarioService.class.getSimpleName());
	
	@Autowired
    private UsuarioExternoDao usuarioExternoDao;
	public void setUsuarioExternoDao(UsuarioExternoDao usuarioExternoDao) {
		this.usuarioExternoDao = usuarioExternoDao;
	}
	
	@Transactional
	public void persist(Session session, UsuarioExterno usuarioExterno){
		log.info("Entrando servicio...");
		usuarioExternoDao.persist(session,usuarioExterno);
	}
	
	public List<UsuarioExterno> list(){
		log.info("Entrando a servicio list...");
		return usuarioExternoDao.findAll();
	}
}