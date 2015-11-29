package com.codinghome.bibliouned.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.util.ViewUtil;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Service("consultaUsuarioService")
public class ConsultaUsuariosService {
	
	@Autowired
    private UsuarioExternoDao usuarioExternoDao;
	public void setUsuarioExternoDao(UsuarioExternoDao usuarioExternoDao) {
		this.usuarioExternoDao = usuarioExternoDao;
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
	
	public UsuarioExternoView getUsuarioExterno(Session session, String identificador) {
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		UsuarioExterno usuario = usuarioExternoDao.getUsuarioExternoByIdentificador(session, identificador);
		if (usuario != null){
			usuarioExterno.setNombre(usuario.getNombre());
			usuarioExterno.setApellido1(usuario.getApellido1());
			usuarioExterno.setApellido2(usuario.getApellido2());
			usuarioExterno.setIdentificador(usuario.getIdentificador());
			usuarioExterno.setNifPasaporte(usuario.getNifPasaporte());
			usuarioExterno.setTelefono(usuario.getTelefono());
			usuarioExterno.setMail(usuario.getMail());
			usuarioExterno.setLocalidad(usuario.getLocalidad());
		}
		return usuarioExterno;
	}
	
	public List<UsuarioExternoView> findUsuariosExternos(Session session, UsuarioExternoView usuarioExterno) {
		List<UsuarioExterno> usuariosExternos = usuarioExternoDao.getUsuariosExternosFiltrados(session, usuarioExterno);
		List<UsuarioExternoView> usuariosExternosView = new ArrayList<>();
		for (UsuarioExterno elem : usuariosExternos){
			usuariosExternosView.add(viewUtil.getViewFromUsuarioExterno(elem));
		}
		return usuariosExternosView;
	}
	
}
