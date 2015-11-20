package com.codinghome.bibliouned.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.codinghome.bibliouned.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDao {

//	private static final Log log = LogFactory.getLog(UsuarioDao.class);

	public Usuario getUsuarioByUsername(Session session, String identificador) {
		Criteria crit = session.createCriteria(Usuario.class);
		crit.add(Restrictions.eq("usuario", identificador));
		Usuario instance = (Usuario) crit.uniqueResult();
		return instance;
	}
}
