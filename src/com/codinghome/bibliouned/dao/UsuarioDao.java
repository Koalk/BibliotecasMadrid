package com.codinghome.bibliouned.dao;

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

	public Usuario findByIdentificador(Session session, String identificador) {
		log.debug("getting Usuario instance with identificador: " + identificador);
		try {
			Criteria crit = session.createCriteria(Usuario.class);
			crit.add(Restrictions.eq("identificador", identificador));
			Usuario instance = (Usuario) crit.uniqueResult();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
