package com.codinghome.bibliouned.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.codinghome.bibliouned.model.Biblioteca;

/**
 * Home object for domain model class Biblioteca.
 * @see .Biblioteca
 * @author Hibernate Tools
 */
@Stateless
public class BibliotecaHome {

	private static final Log log = LogFactory.getLog(BibliotecaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Biblioteca transientInstance) {
		log.debug("persisting Biblioteca instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Biblioteca persistentInstance) {
		log.debug("removing Biblioteca instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Biblioteca merge(Biblioteca detachedInstance) {
		log.debug("merging Biblioteca instance");
		try {
			Biblioteca result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Biblioteca findById(Long id) {
		log.debug("getting Biblioteca instance with id: " + id);
		try {
			Biblioteca instance = entityManager.find(Biblioteca.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
