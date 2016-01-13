package com.codinghome.bibliouned.service;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.BibliotecaDao;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.util.ViewUtil;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Service("altaUsuarioService")
public class AltaUsuarioService {

	Logger log = Logger.getLogger(AltaUsuarioService.class.getSimpleName());
	
	@Autowired
    private UsuarioExternoDao usuarioExternoDao;
	public void setUsuarioExternoDao(UsuarioExternoDao usuarioExternoDao) {
		this.usuarioExternoDao = usuarioExternoDao;
	}
	@Autowired
	private BibliotecaDao bibliotecaDao;
	public void setBibliotecaDao(BibliotecaDao bibliotecaDao) {
		this.bibliotecaDao = bibliotecaDao;
	}
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
	
	public void persist(Session session, UsuarioExternoView usuarioExternoView, String path, String name){
		UsuarioExterno usuarioExterno = viewUtil.getUsuarioExternoFromView(session, name, usuarioExternoView);
		usuarioExterno.setFoto(path);
		usuarioExternoDao.persist(session,usuarioExterno);
		usuarioExternoView.setIdentificador(usuarioExterno.getIdentificador());
	}
	
	public UsuarioExternoView getNewUsuarioExterno(Session session, String name) {
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		Usuario usuario = usuarioDao.getUsuarioByUsername(session, name);
		Biblioteca biblioteca = usuario.getBiblioteca();
		usuarioExterno.setBiblioteca(biblioteca.getNombre());
		return usuarioExterno;
	}
	
	public UsuarioExternoView getUsuarioExternoByIdentificador(Session session, String identificador) {
		UsuarioExternoView usuarioExterno = viewUtil.getViewFromUsuarioExterno(usuarioExternoDao.getUsuarioExternoByIdentificador(session, identificador));
		return usuarioExterno;
	}
	
	public Boolean existsNIF(Session session, String nif, String identificador) {
		Boolean result = false;
		List<UsuarioExterno> usuarioExternoList = usuarioExternoDao.getUsuarioExternoByNif(session, nif);
		if ((identificador == null && !usuarioExternoList.isEmpty()) || usuarioExternoList.stream().anyMatch(elem -> !elem.getIdentificador().equals(identificador))){
			result = true;
		}
		return result;
	}
	
}