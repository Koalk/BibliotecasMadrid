package com.codinghome.bibliouned.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.model.Usuario;

@Service
public class UserService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public Usuario loadUserByIdentificador(Session session, final String identificador) 
            throws UsernameNotFoundException {

		Usuario user = usuarioDao.getUsuarioByUsername(session, identificador);
//		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());

		return null;//buildUserForAuthentication(user, authorities);
	}
	
	private Usuario buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
		return new Usuario(user.getBiblioteca(), user.getUsuario(), user.getEmail(), user.getPassword(), user.getCreateTime(), user.getUserRoles(), user.getUsuarioexternos());
	}
	
}
