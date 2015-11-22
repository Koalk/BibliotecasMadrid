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
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Repository("usuarioExternoDao")
public class UsuarioExternoDao {

	private static final Log log = LogFactory.getLog(UsuarioExternoDao.class);
	private final String CADENA_VACIA = "";

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
	
	public List<UsuarioExterno> getUsuariosExternosFiltrados(Session session, UsuarioExternoView usuarioExterno) {
		Criteria crit = session.createCriteria(UsuarioExterno.class);
		if (usuarioExterno.getNombre() != null && !CADENA_VACIA.equals(usuarioExterno.getNombre())) {
			crit.add(Restrictions.eq("nombre", usuarioExterno.getNombre()));
		}
		if (usuarioExterno.getApellido1() != null && !CADENA_VACIA.equals(usuarioExterno.getApellido1())) {
			crit.add(Restrictions.eq("apellido1", usuarioExterno.getApellido1()));
		}
		if (usuarioExterno.getApellido2() != null && !CADENA_VACIA.equals(usuarioExterno.getApellido2())) {
			crit.add(Restrictions.eq("apellido2", usuarioExterno.getApellido2()));
		}
		if (usuarioExterno.getIdentificador() != null && !CADENA_VACIA.equals(usuarioExterno.getIdentificador())) {
			crit.add(Restrictions.eq("identificador", usuarioExterno.getIdentificador()));
		}
		if (usuarioExterno.getNifPasaporte() != null && !CADENA_VACIA.equals(usuarioExterno.getNifPasaporte())) {
			crit.add(Restrictions.eq("nifPasaporte", usuarioExterno.getNifPasaporte()));
		}
		if (usuarioExterno.getTelefono() != null && !CADENA_VACIA.equals(usuarioExterno.getTelefono())) {
			crit.add(Restrictions.eq("telefono", usuarioExterno.getTelefono()));
		}
		if (usuarioExterno.getMail() != null && !CADENA_VACIA.equals(usuarioExterno.getMail())) {
			crit.add(Restrictions.eq("mail", usuarioExterno.getMail()));
		}
		if (usuarioExterno.getLocalidad() != null && !CADENA_VACIA.equals(usuarioExterno.getLocalidad())) {
			crit.add(Restrictions.eq("localidad", usuarioExterno.getLocalidad()));
		}
		List<UsuarioExterno> results = (List<UsuarioExterno>) crit.list();
//		UsuarioExterno usuarioExterno = (UsuarioExterno) crit.uniqueResult();
		return results;
	}
}
