package com.codinghome.bibliouned.dao;

import org.easymock.EasyMock;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.model.Biblioteca;

/**
 * The class <code>BibliotecaDaoTest</code> contains tests for the class <code>{@link BibliotecaDao}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class BibliotecaDaoTest {
	/**
	 * Run the Biblioteca getBibliotecaByUsername(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetBibliotecaByUsername_1()
		throws Exception {
		BibliotecaDao fixture = new BibliotecaDao();
		Session session = EasyMock.createMock(Session.class);
		String userName = "";
		// add mock object expectations here

		EasyMock.replay(session);

		Biblioteca result = fixture.getBibliotecaByUsername(session, userName);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.BibliotecaDao.getBibliotecaByUsername(BibliotecaDao.java:20)
		assertNotNull(result);
	}

	/**
	 * Run the Biblioteca getBibliotecaByUsername(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetBibliotecaByUsername_2()
		throws Exception {
		BibliotecaDao fixture = new BibliotecaDao();
		Session session = EasyMock.createMock(Session.class);
		String userName = "";
		// add mock object expectations here

		EasyMock.replay(session);

		Biblioteca result = fixture.getBibliotecaByUsername(session, userName);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.dao.BibliotecaDao.getBibliotecaByUsername(BibliotecaDao.java:20)
		assertNotNull(result);
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
		new org.junit.runner.JUnitCore().run(BibliotecaDaoTest.class);
	}
}