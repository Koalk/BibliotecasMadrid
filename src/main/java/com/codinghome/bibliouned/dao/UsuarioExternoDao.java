package com.codinghome.bibliouned.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioExternoView;

@Repository("usuarioExternoDao")
public class UsuarioExternoDao {

	private static final Log log = LogFactory.getLog(UsuarioExternoDao.class);
	private final String CADENA_VACIA = "";

	public void persist(Session session, UsuarioExterno usuarioExterno) {
		log.debug("persisting UsuarioExterno instance");
		try {
			if (usuarioExterno.getIdentificador() != null){
				session.update(usuarioExterno);
			}
			else {
				usuarioExterno.setCreateTime(new Date());
				session.save(usuarioExterno);
				String identificador = usuarioExterno.getBiblioteca().getIdentificador() + fillWithZero(usuarioExterno.getId(), 6);
				usuarioExterno.setIdentificador(identificador);
				session.update(usuarioExterno);
			}
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	private String fillWithZero(Long n, Integer size){
		String result = n.toString();
		for (int i=0; i < size; i++){
			result = "0"+result;
		}
		return result;
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
	
	@SuppressWarnings("unchecked")
	public List<UsuarioExterno> getUsuarioExternoByNif(Session session, String nif) {
		Criteria crit = session.createCriteria(UsuarioExterno.class);
		crit.add(Restrictions.eq("nifPasaporte", nif));
		List<UsuarioExterno> usuarioExternoList = crit.list();
		return usuarioExternoList;
	}
	
	public List<UsuarioExterno> getUsuariosExternosFiltrados(Session session, UsuarioExternoView usuarioExterno) {
		Criteria crit = session.createCriteria(UsuarioExterno.class);
		if (usuarioExterno.getNombre() != null && !CADENA_VACIA.equals(usuarioExterno.getNombre())) {
			crit.add(Restrictions.like("nombre", usuarioExterno.getNombre(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getApellido1() != null && !CADENA_VACIA.equals(usuarioExterno.getApellido1())) {
			crit.add(Restrictions.like("apellido1", usuarioExterno.getApellido1(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getApellido2() != null && !CADENA_VACIA.equals(usuarioExterno.getApellido2())) {
			crit.add(Restrictions.like("apellido2", usuarioExterno.getApellido2(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getIdentificador() != null && !CADENA_VACIA.equals(usuarioExterno.getIdentificador())) {
			crit.add(Restrictions.like("identificador", usuarioExterno.getIdentificador(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getNifPasaporte() != null && !CADENA_VACIA.equals(usuarioExterno.getNifPasaporte())) {
			crit.add(Restrictions.like("nifPasaporte", usuarioExterno.getNifPasaporte(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getTelefono() != null && !CADENA_VACIA.equals(usuarioExterno.getTelefono())) {
			crit.add(Restrictions.like("telefono", usuarioExterno.getTelefono(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getMail() != null && !CADENA_VACIA.equals(usuarioExterno.getMail())) {
			crit.add(Restrictions.like("mail", usuarioExterno.getMail(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getLocalidad() != null && !CADENA_VACIA.equals(usuarioExterno.getLocalidad())) {
			crit.add(Restrictions.like("localidad", usuarioExterno.getLocalidad(), MatchMode.ANYWHERE));
		}
		if (usuarioExterno.getBiblioteca() != null && !CADENA_VACIA.equals(usuarioExterno.getBiblioteca())) {
			Criteria critBiblioteca = crit.createCriteria("biblioteca", JoinType.INNER_JOIN);
			critBiblioteca.add(Restrictions.or(
					Restrictions.like("nombre", usuarioExterno.getBiblioteca(), MatchMode.ANYWHERE),
					Restrictions.like("identificador", usuarioExterno.getBiblioteca(), MatchMode.ANYWHERE)));
		}
		@SuppressWarnings("unchecked")
		List<UsuarioExterno> results = (List<UsuarioExterno>) crit.list();
		return results;
	}
}
