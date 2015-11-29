package com.codinghome.bibliouned;

import org.easymock.classextension.EasyMock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.validation.BindingResult;

public class MockingUtils {
	
	public static SessionFactory getSessionFactoryMock(){
		SessionFactory sessionFactory = EasyMock.createNiceMock(SessionFactory.class);
		Session session = EasyMock.createNiceMock(Session.class);
		Transaction tx = EasyMock.createNiceMock(Transaction.class);
		EasyMock.expect(sessionFactory.getCurrentSession()).andReturn(session);
		EasyMock.expect(sessionFactory.openSession()).andReturn(session);
		EasyMock.expect(session.beginTransaction()).andReturn(tx);
		EasyMock.expect(session.getTransaction()).andReturn(tx);
		EasyMock.replay(sessionFactory,session,tx);
		return sessionFactory;
	}
	
	public static BindingResult getResultWithErrors(){
		BindingResult result = EasyMock.createNiceMock(BindingResult.class);
		EasyMock.expect(result.hasErrors()).andReturn(true);
		return result;
	}
	
	public static BindingResult getResultWithoutErrors(){
		BindingResult result = EasyMock.createNiceMock(BindingResult.class);
		EasyMock.expect(result.hasErrors()).andReturn(false);
		return result;
	}
}
