package com.codinghome.bibliouned.dao;

import java.util.Date;
import java.util.List;
import org.easymock.EasyMock;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioExternoView;

/**
 * The class <code>UsuarioExternoDaoTest</code> contains tests for the class <code>{@link UsuarioExternoDao}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class UsuarioExternoDaoTest {
	/**
	 * Run the UsuarioExternoDao() constructor test.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testUsuarioExternoDao_1()
		throws Exception {
		UsuarioExternoDao result = new UsuarioExternoDao();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the List<UsuarioExterno> findAll() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testFindAll_1()
		throws Exception {
		UsuarioExternoDao fixture = new UsuarioExternoDao();

		List<UsuarioExterno> result = fixture.findAll();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String getLastIdNumber(Session,Biblioteca) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetLastIdNumber_1()
		throws Exception {
		UsuarioExternoDao fixture = new UsuarioExternoDao();
		Session session = EasyMock.createMock(Session.class);
		Biblioteca biblioteca = new Biblioteca();
		// add mock object expectations here

		EasyMock.replay(session);

		String result = fixture.getLastIdNumber(session, biblioteca);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.UsuarioExternoDao.getLastIdNumber(UsuarioExternoDao.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the String getLastIdNumber(Session,Biblioteca) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetLastIdNumber_2()
		throws Exception {
		UsuarioExternoDao fixture = new UsuarioExternoDao();
		Session session = EasyMock.createMock(Session.class);
		Biblioteca biblioteca = new Biblioteca();
		// add mock object expectations here

		EasyMock.replay(session);

		String result = fixture.getLastIdNumber(session, biblioteca);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.UsuarioExternoDao.getLastIdNumber(UsuarioExternoDao.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExterno getUsuarioExternoByIdentificador(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExternoByIdentificador_1()
		throws Exception {
		UsuarioExternoDao fixture = new UsuarioExternoDao();
		Session session = EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExterno result = fixture.getUsuarioExternoByIdentificador(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.UsuarioExternoDao.getUsuarioExternoByIdentificador(UsuarioExternoDao.java:73)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExterno getUsuarioExternoByIdentificador(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExternoByIdentificador_2()
		throws Exception {
		UsuarioExternoDao fixture = new UsuarioExternoDao();
		Session session = EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExterno result = fixture.getUsuarioExternoByIdentificador(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.UsuarioExternoDao.getUsuarioExternoByIdentificador(UsuarioExternoDao.java:73)
		assertNotNull(result);
	}

	/**
	 * Run the void persist(Session,UsuarioExterno) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testPersist_1()
		throws Exception {
		UsuarioExternoDao fixture = new UsuarioExternoDao();
		Session session = EasyMock.createMock(Session.class);
		UsuarioExterno usuarioExterno = new UsuarioExterno(new Biblioteca(), new Usuario(), "", "", "", "", "", "", "", "", "", "", "", new Date());
		// add mock object expectations here

		EasyMock.replay(session);

		fixture.persist(session, usuarioExterno);

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
		new org.junit.runner.JUnitCore().run(UsuarioExternoDaoTest.class);
	}
}