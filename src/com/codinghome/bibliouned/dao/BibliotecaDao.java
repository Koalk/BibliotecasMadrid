package com.codinghome.bibliouned.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Usuario;

@Repository("bibliotecaDao")
public class BibliotecaDao {

//	private static final Logger log = Logger.getLogger(BibliotecaDao.class.getSimpleName());

	public Biblioteca getBibliotecaByUsername(Session session, String userName){
		Biblioteca result = null;
		Criteria crit = session.createCriteria(Usuario.class);
		crit.add(Restrictions.eq("usuario", userName));
		crit.setProjection(Projections.property("biblioteca"));
		result = (Biblioteca) crit.uniqueResult();
		return result;
	}
}
