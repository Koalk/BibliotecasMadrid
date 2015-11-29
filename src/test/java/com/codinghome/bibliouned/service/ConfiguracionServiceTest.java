package com.codinghome.bibliouned.service;

import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;
import org.easymock.classextension.EasyMock;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.UserRole;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioView;

/**
 * The class <code>ConfiguracionServiceTest</code> contains tests for the class <code>{@link ConfiguracionService}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class ConfiguracionServiceTest {
	/**
	 * Run the ConfiguracionService() constructor test.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testConfiguracionService_1()
		throws Exception {
		ConfiguracionService result = new ConfiguracionService();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the UsuarioView getUsuarioByIdentificador(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioByIdentificador_1()
		throws Exception {
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String userName = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioView result = fixture.getUsuarioByIdentificador(session, userName);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.ConfiguracionService.getViewFromUsuario(ConfiguracionService.java:39)
		//       at com.codinghome.bibliouned.service.ConfiguracionService.getUsuarioByIdentificador(ConfiguracionService.java:33)
		assertNotNull(result);
	}

	/**
	 * Run the Usuario getUsuarioFromView(Session,String,UsuarioView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioFromView_1()
		throws Exception {
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String name = "";
		UsuarioView view = new UsuarioView();
		view.setUsuario("");
		view.setApellidos("");
		view.setMail("");
		// add mock object expectations here

		EasyMock.replay(session);

		Usuario result = fixture.getUsuarioFromView(session, name, view);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.ConfiguracionService.getUsuarioFromView(ConfiguracionService.java:50)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioView getViewFromUsuario(Usuario) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetViewFromUsuario_1()
		throws Exception {
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Usuario usuario = new Usuario(new Biblioteca(), "", "", "", new Date(), org.easymock.EasyMock.createNiceMock(Set.class), org.easymock.EasyMock.createNiceMock(Set.class));
		usuario.setNombre("");
		usuario.setApellidos("");

		UsuarioView result = fixture.getViewFromUsuario(usuario);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getPassword());
		assertEquals("", result.getUsuario());
		assertEquals("", result.getNombre());
		assertEquals("", result.getMail());
		assertEquals(null, result.getNewPassword());
		assertEquals("", result.getApellidos());
		assertEquals(null, result.getConfirmPassword());
	}

	/**
	 * Run the boolean isDuplicatedUserName(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testIsDuplicatedUserName_1()
		throws Exception {
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String usuario = "";
		// add mock object expectations here

		EasyMock.replay(session);

		boolean result = fixture.isDuplicatedUserName(session, usuario);

		// add additional test code here
		EasyMock.verify(session);
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isDuplicatedUserName(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testIsDuplicatedUserName_2()
		throws Exception {
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String usuario = "";
		// add mock object expectations here

		EasyMock.replay(session);

		boolean result = fixture.isDuplicatedUserName(session, usuario);

		// add additional test code here
		EasyMock.verify(session);
		assertEquals(false, result);
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
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		Usuario usuario = new Usuario();
		// add mock object expectations here

		EasyMock.replay(session);

		fixture.persist(session, usuario);

		// add additional test code here
		EasyMock.verify(session);
	}

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
		ConfiguracionService fixture = new ConfiguracionService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.log = Logger.getAnonymousLogger();
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
		new org.junit.runner.JUnitCore().run(ConfiguracionServiceTest.class);
	}
}