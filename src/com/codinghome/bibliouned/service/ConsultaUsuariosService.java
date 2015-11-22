package com.codinghome.bibliouned.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.UsuarioExterno;
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
	
	public UsuarioExternoView getUsuarioExterno(Session session, String name) {
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		UsuarioExterno usuario = usuarioExternoDao.getUsuarioExternoByIdentificador(session, name);
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
	
	public List<UsuarioExterno> findUsuariosExternos(Session session, UsuarioExternoView usuarioExterno) {
		List<UsuarioExterno> usuariosExternos = usuarioExternoDao.getUsuariosExternosFiltrados(session, usuarioExterno);
		return usuariosExternos;
	}
	
}
