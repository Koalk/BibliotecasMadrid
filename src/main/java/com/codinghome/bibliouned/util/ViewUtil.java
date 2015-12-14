package com.codinghome.bibliouned.util;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codinghome.bibliouned.dao.BibliotecaDao;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Constants;
import com.codinghome.bibliouned.model.UserRole;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioExternoView;
import com.codinghome.bibliouned.view.UsuarioView;

@Component
public class ViewUtil {

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
		view.setProvincia(usuarioExterno.getProvincia());
		view.setMail(usuarioExterno.getMail());
		view.setNifPasaporte(usuarioExterno.getNifPasaporte());
		view.setObservaciones(usuarioExterno.getObservaciones());
		view.setTelefono(usuarioExterno.getTelefono());
		view.setFoto(usuarioExterno.getFoto());
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
		usuarioExterno.setProvincia(view.getProvincia());
		usuarioExterno.setMail(view.getMail());
		usuarioExterno.setNifPasaporte(view.getNifPasaporte());
		usuarioExterno.setObservaciones(view.getObservaciones());
		usuarioExterno.setTelefono(view.getTelefono());
		return usuarioExterno;
	}

	public UsuarioView getViewFromUsuario (Usuario usuario, Boolean admin){
		UsuarioView view = new UsuarioView();
		view.setUsuario(usuario.getUsuario());
		view.setPassword(usuario.getPassword());
		view.setNombre(usuario.getNombre());
		view.setApellidos(usuario.getApellidos());
		view.setMail(usuario.getEmail());
		if (admin){
			view.setEnabled(usuario.getActive());
			view.setAdminRole(usuario.getUserRoles().stream().anyMatch(elem -> Constants.ROLE_ADMIN.equals(elem.getRole())));
			view.setUserRole(usuario.getUserRoles().stream().anyMatch(elem -> Constants.ROLE_USER.equals(elem.getRole())));
		}
		return view;
	}

	public Usuario getUsuarioFromView (Session session, String name, UsuarioView view, Boolean admin){
		Usuario usuario = null;
		if (name == null){
			usuario = usuarioDao.getUsuarioByUsername(session, name);
		}
		else{
			usuario = new Usuario();
		}
		usuario.setUsuario(view.getUsuario());
		usuario.setApellidos(view.getApellidos());
		usuario.setEmail(view.getMail());
		if (admin){
			usuario.setActive(view.getEnabled());
			if (view.getAdminRole() && !usuario.getUserRoles().stream().anyMatch(elem -> Constants.ROLE_ADMIN.equals(elem.getRole()))){
				usuario.getUserRoles().add(new UserRole(usuario,Constants.ROLE_ADMIN));
			}
			if (view.getUserRole() && !usuario.getUserRoles().stream().anyMatch(elem -> Constants.ROLE_USER.equals(elem.getRole()))){
				usuario.getUserRoles().add(new UserRole(usuario,Constants.ROLE_USER));
			}
		}
		return usuario;
	}
}