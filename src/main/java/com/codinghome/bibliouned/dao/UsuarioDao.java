package com.codinghome.bibliouned.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.codinghome.bibliouned.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDao {

	private static final Log log = LogFactory.getLog(UsuarioDao.class);

	public Usuario getUsuarioByUsername(Session session, String identificador) {
		Criteria crit = session.createCriteria(Usuario.class);
		crit.add(Restrictions.eq("usuario", identificador));
		Usuario instance = (Usuario) crit.uniqueResult();
		return instance;
	}
	
	public void save(Session session, Usuario usuario) {
		log.debug("persisting UsuarioExterno instance");
		try {
			session.save(usuario);
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void update(Session session, Usuario usuario) {
		session.update(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list(Session session) {
		Criteria crit = session.createCriteria(Usuario.class);
		return crit.list();
	}
	
}