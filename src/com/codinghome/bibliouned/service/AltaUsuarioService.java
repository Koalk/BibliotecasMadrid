package com.codinghome.bibliouned.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.BibliotecaDao;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
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
	
	@Transactional
	public void persist(Session session, UsuarioExterno usuarioExterno){
		log.info("Entrando servicio...");
		usuarioExternoDao.persist(session,usuarioExterno);
	}
	
	public List<UsuarioExterno> list(){
		log.info("Entrando a servicio list...");
		return usuarioExternoDao.findAll();
	}

	public UsuarioExternoView getNewUsuarioExterno(Session session, String name) {
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		Usuario usuario = usuarioDao.getUsuarioByUsername(session, name);
		Biblioteca biblioteca = usuario.getBiblioteca();
		usuarioExterno.setBiblioteca(biblioteca.getNombre());
//		para probar modificación
//		usuarioExterno = getViewFromUsuarioExterno(usuarioExternoDao.getUsuarioExternoByIdentificador(session, "ITU1"));
		return usuarioExterno;
	}
	
	public UsuarioExternoView getViewFromUsuarioExterno (UsuarioExterno usuarioExterno){
		UsuarioExternoView view = new UsuarioExternoView();
		view.setIdentificador(usuarioExterno.getIdentificador());
		view.setBiblioteca(usuarioExterno.getBiblioteca() != null ? usuarioExterno.getBiblioteca().getNombre() : "");
		view.setNombre(usuarioExterno.getNombre());
		view.setApellido1(usuarioExterno.getApellido1());
		view.setApellido2(usuarioExterno.getApellido2());
		view.setCodigoPostal(usuarioExterno.getCodigoPostal());
		view.setDireccion(usuarioExterno.getDireccion());
		view.setLocalidad(usuarioExterno.getLocalidad());
		view.setMail(usuarioExterno.getMail());
		view.setNifPasaporte(usuarioExterno.getNifPasaporte());
		view.setObservaciones(usuarioExterno.getObservaciones());
		view.setTelefono(usuarioExterno.getTelefono());
//		view.setFoto(usuarioExterno.getFoto());
		return view;
	}
	
	public UsuarioExterno getUsuarioExternoFromView (Session session, String name, UsuarioExternoView view){
		UsuarioExterno usuarioExterno = null;
		if (view.getIdentificador()!= null && !view.getIdentificador().isEmpty() && !view.getIdentificador().equals("")){
			usuarioExterno = usuarioExternoDao.getUsuarioExternoByIdentificador(session, view.getIdentificador());
		}
		else {
			usuarioExterno = new UsuarioExterno();
			Usuario usuario = usuarioDao.getUsuarioByUsername(session, name);
			Biblioteca biblioteca = usuario.getBiblioteca();
			usuarioExterno.setUsuario(usuario);
			usuarioExterno.setBiblioteca(biblioteca);
		}
		usuarioExterno.setNombre(view.getNombre());
		usuarioExterno.setApellido1(view.getApellido1());
		usuarioExterno.setApellido2(view.getApellido2());
		usuarioExterno.setCodigoPostal(view.getCodigoPostal());
		usuarioExterno.setDireccion(view.getDireccion());
		usuarioExterno.setLocalidad(view.getLocalidad());
		usuarioExterno.setMail(view.getMail());
		usuarioExterno.setNifPasaporte(view.getNifPasaporte());
		usuarioExterno.setObservaciones(view.getObservaciones());
		usuarioExterno.setTelefono(view.getTelefono());
//		usuarioExterno.setFoto(view.getFoto());
		return usuarioExterno;
	}
}