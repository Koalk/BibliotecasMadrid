package com.codinghome.bibliouned.service;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioExternoView;
import com.codinghome.bibliouned.view.UsuarioView;

@Service("configuracionService")
public class ConfiguracionService {

	Logger log = Logger.getLogger(ConfiguracionService.class.getSimpleName());
	
	@Autowired
	private UsuarioDao usuarioDao;
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@Transactional
	public void persist(Session session, Usuario usuario){
		log.info("Entrando servicio...");
		usuarioDao.persist(session,usuario);
	}
	
	public UsuarioView getUsuarioByIdentificador(Session session, String identificador) {
		UsuarioView usuario = getViewFromUsuario(usuarioDao.getUsuarioByUsername(session, identificador));
		return usuario;
	}
	
	public UsuarioView getViewFromUsuario (Usuario usuario){
		UsuarioView view = new UsuarioView();
		view.setUsuario(usuario.getUsuario());
		view.setPassword(usuario.getPassword());
		return view;
	}
	
	public Usuario getUsuarioFromView (Session session, String name, UsuarioView view){
		Usuario usuario = null;
		if (view.getUsuario()!= null && !view.getUsuario().isEmpty() && !view.getUsuario().equals("")){
			usuario = usuarioDao.getUsuarioByUsername(session, view.getUsuario());
		}
		usuario.setUsuario(view.getUsuario());
		usuario.setPassword(view.getPassword());
		return usuario;
	}

}