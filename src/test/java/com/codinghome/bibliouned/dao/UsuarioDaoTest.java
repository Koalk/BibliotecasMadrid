package com.codinghome.bibliouned.dao;

import org.easymock.EasyMock;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.model.Usuario;

/**
 * The class <code>UsuarioDaoTest</code> contains tests for the class <code>{@link UsuarioDao}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class UsuarioDaoTest {
	/**
	 * Run the UsuarioDao() constructor test.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testUsuarioDao_1()
		throws Exception {
		UsuarioDao result = new UsuarioDao();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Usuario getUsuarioByUsername(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioByUsername_1()
		throws Exception {
		UsuarioDao fixture = new UsuarioDao();
		Session session = EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		Usuario result = fixture.getUsuarioByUsername(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.UsuarioDao.getUsuarioByUsername(UsuarioDao.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Usuario getUsuarioByUsername(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioByUsername_2()
		throws Exception {
		UsuarioDao fixture = new UsuarioDao();
		Session session = EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		Usuario result = fixture.getUsuarioByUsername(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.UsuarioDao.getUsuarioByUsername(UsuarioDao.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the void persist(Session,Usuario) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testPersist_1()
		throws Exception {
		UsuarioDao fixture = new UsuarioDao();
		Session session = EasyMock.createMock(Session.class);
		Usuario usuario = new Usuario();
		// add mock object expectations here

		EasyMock.replay(session);

		fixture.persist(session, usuario);

		// add additional test code here
		EasyMock.verify(session);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UsuarioDaoTest.class);
	}
}