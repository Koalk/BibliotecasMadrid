package com.codinghome.bibliouned.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.UsuarioExterno;

@Repository("usuarioExternoDao")
public class UsuarioExternoDao {

	private static final Log log = LogFactory.getLog(UsuarioExternoDao.class);

	public void persist(Session session, UsuarioExterno transientInstance) {
		log.debug("persisting UsuarioExterno instance");
		try {
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public List<UsuarioExterno> findAll(){
		log.debug("getting all UsuarioExterno");
		try{
			List<UsuarioExterno> result = null;
			return result;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public String getLastIdNumber(Session session, Biblioteca biblioteca) {
		Criteria crit = session.createCriteria(UsuarioExterno.class);
		crit.add(Restrictions.eq("biblioteca", biblioteca));
		crit.setProjection(Projections.max("identificador"));
		String result = (String) crit.uniqueResult();
		return result;
	}

	public UsuarioExterno getUsuarioExternoByIdentificador(Session session, String identificador) {
		Criteria crit = session.createCriteria(UsuarioExterno.class);
		crit.add(Restrictions.eq("identificador", identificador));
		UsuarioExterno usuarioExterno = (UsuarioExterno) crit.uniqueResult();
		return usuarioExterno;
	}
}
