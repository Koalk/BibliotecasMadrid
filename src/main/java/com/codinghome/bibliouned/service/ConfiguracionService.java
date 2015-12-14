package com.codinghome.bibliouned.service;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.util.ViewUtil;
import com.codinghome.bibliouned.view.UsuarioView;

@Service("configuracionService")
public class ConfiguracionService {

	Logger log = Logger.getLogger(ConfiguracionService.class.getSimpleName());
	
	@Autowired
	private UsuarioDao usuarioDao;
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	@Autowired
	private ViewUtil viewUtil;
	public void setViewUtil(ViewUtil viewUtil) {
		this.viewUtil = viewUtil;
	}
	
	@Transactional
	public void persist(Session session, Usuario usuario){
		log.info("Entrando servicio...");
		if (usuario.getId() != null){
			usuarioDao.update(session,usuario);
		}
		else {
			usuarioDao.save(session,usuario);
		}
	}
	
	public UsuarioView getUsuarioByIdentificador(Session session, String userName) {
		UsuarioView usuario = viewUtil.getViewFromUsuario(usuarioDao.getUsuarioByUsername(session, userName),false);
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