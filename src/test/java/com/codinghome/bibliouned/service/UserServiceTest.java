package com.codinghome.bibliouned.service;

import org.easymock.classextension.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.dao.UsuarioDao;

/**
 * The class <code>UserServiceTest</code> contains tests for the class <code>{@link UserService}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class UserServiceTest {
	/**
	 * Run the void setUsuarioDao(UsuarioDao) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testSetUsuarioDao_1()
		throws Exception {
		UserService fixture = new UserService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		UsuarioDao usuarioDao = EasyMock.createMock(UsuarioDao.class);
		// add mock object expectations here

		EasyMock.replay(usuarioDao);

		fixture.setUsuarioDao(usuarioDao);

		// add additional test code here
		EasyMock.verify(usuarioDao);
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
		new org.junit.runner.JUnitCore().run(UserServiceTest.class);
	}
}