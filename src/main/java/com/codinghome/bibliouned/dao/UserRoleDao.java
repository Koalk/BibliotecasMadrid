package com.codinghome.bibliouned.dao;

import org.hibernate.Session;

import com.codinghome.bibliouned.model.UserRole;

public class UserRoleDao {
	
	public void persist(Session session, UserRole userRole){
		session.persist(userRole);
	}
	
	public void update(Session session, UserRole userRole){
		session.update(userRole);
	}

}
