package com.codinghome.bibliouned.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.codinghome.bibliouned.model.UsuarioExterno;

/**
 * Home object for domain model class UsuarioExterno.
 * @see .UsuarioExterno
 * @author Hibernate Tools
 */
@Stateless
public class UsuarioExternoHome {

	private static final Log log = LogFactory.getLog(UsuarioExternoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UsuarioExterno transientInstance) {
		log.debug("persisting UsuarioExterno instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UsuarioExterno persistentInstance) {
		log.debug("removing UsuarioExterno instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UsuarioExterno merge(UsuarioExterno detachedInstance) {
		log.debug("merging UsuarioExterno instance");
		try {
			UsuarioExterno result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UsuarioExterno findById(Long id) {
		log.debug("getting UsuarioExterno instance with id: " + id);
		try {
			UsuarioExterno instance = entityManager.find(UsuarioExterno.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
