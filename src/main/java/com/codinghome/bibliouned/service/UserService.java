package com.codinghome.bibliouned.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UserRoleDao;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.util.ViewUtil;
import com.codinghome.bibliouned.view.UsuarioView;

@Service
public class UserService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@Autowired
	private UserRoleDao userRoleDao;
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	@Autowired
	private ViewUtil viewUtil;
	public void setViewUtil(ViewUtil viewUtil) {
		this.viewUtil = viewUtil;
	}
	
	public UsuarioView getUsuarioViewById(Session session, String identificador){
		return viewUtil.getViewFromUsuario(usuarioDao.getUsuarioByUsername(session, identificador), true);
	}
	
	public void addUsuario(Session session, Usuario usuario){
		if (usuario.getId() != null){
			this.usuarioDao.update(session, usuario);
		}
		else {
			this.usuarioDao.save(session, usuario);
		}
	}
	
	public List<UsuarioView> getUsuarios(Session session) {
		List<Usuario> usuarioList = usuarioDao.list(session);
		List<UsuarioView> usuarioViewList = new ArrayList<>();
		for (Usuario usuario : usuarioList){
			usuarioViewList.add(viewUtil.getViewFromUsuario(usuario, true));
		}
		return usuarioViewList;
	}
	
	public boolean isDuplicatedUserName(Session session, String usuario) {
		boolean result = false;
		if (usuarioDao.getUsuarioByUsername(session, usuario) != null){
			result = true;
		}
		return result;
	}
}