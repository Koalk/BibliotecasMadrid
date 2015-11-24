package com.codinghome.bibliouned.service;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.model.Usuario;
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
	
	public UsuarioView getUsuarioByIdentificador(Session session, String userName) {
		UsuarioView usuario = getViewFromUsuario(usuarioDao.getUsuarioByUsername(session, userName));
		return usuario;
	}
	
	public UsuarioView getViewFromUsuario (Usuario usuario){
		UsuarioView view = new UsuarioView();
		view.setUsuario(usuario.getUsuario());
		view.setPassword(usuario.getPassword());
		view.setNombre(usuario.getNombre());
		view.setApellidos(usuario.getApellidos());
		view.setMail(usuario.getEmail());
		return view;
	}
	
	public Usuario getUsuarioFromView (Session session, String name, UsuarioView view){
		Usuario usuario = null;
		usuario = usuarioDao.getUsuarioByUsername(session, name);
		usuario.setUsuario(view.getUsuario());
		usuario.setApellidos(view.getApellidos());
		usuario.setEmail(view.getMail());
		return usuario;
	}

	public boolean isDuplicatedUserName(Session session, String usuario) {
		boolean result = false;
		if (usuarioDao.getUsuarioByUsername(session, usuario) != null){
			result = true;
		}
		return result;
	}

}