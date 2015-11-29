package com.codinghome.bibliouned.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.easymock.classextension.EasyMock;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.dao.BibliotecaDao;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.Biblioteca;
import com.codinghome.bibliouned.model.Usuario;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioExternoView;

/**
 * The class <code>AltaUsuarioServiceTest</code> contains tests for the class <code>{@link AltaUsuarioService}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class AltaUsuarioServiceTest {
	/**
	 * Run the AltaUsuarioService() constructor test.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testAltaUsuarioService_1()
		throws Exception {
		AltaUsuarioService result = new AltaUsuarioService();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the UsuarioExternoView getNewUsuarioExterno(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetNewUsuarioExterno_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String name = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExternoView result = fixture.getNewUsuarioExterno(session, name);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.AltaUsuarioService.getNewUsuarioExterno(AltaUsuarioService.java:55)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExternoView getUsuarioExternoByIdentificador(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExternoByIdentificador_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExternoView result = fixture.getUsuarioExternoByIdentificador(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.AltaUsuarioService.getViewFromUsuarioExterno(AltaUsuarioService.java:67)
		//       at com.codinghome.bibliouned.service.AltaUsuarioService.getUsuarioExternoByIdentificador(AltaUsuarioService.java:61)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExterno getUsuarioExternoFromView(Session,String,UsuarioExternoView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExternoFromView_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String name = "";
		UsuarioExternoView view = new UsuarioExternoView();
		view.setLocalidad("");
		view.setDireccion("");
		view.setCodigoPostal("");
		view.setTelefono("");
		view.setNombre("");
		view.setMail("");
		view.setApellido2("");
		view.setIdentificador("");
		view.setObservaciones("");
		view.setApellido1("");
		view.setNifPasaporte("");
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExterno result = fixture.getUsuarioExternoFromView(session, name, view);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.AltaUsuarioService.getUsuarioExternoFromView(AltaUsuarioService.java:91)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExterno getUsuarioExternoFromView(Session,String,UsuarioExternoView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExternoFromView_2()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String name = "";
		UsuarioExternoView view = new UsuarioExternoView();
		view.setLocalidad("");
		view.setDireccion("");
		view.setCodigoPostal("");
		view.setTelefono("");
		view.setNombre("");
		view.setMail("");
		view.setApellido2("");
		view.setIdentificador("");
		view.setObservaciones("");
		view.setApellido1("");
		view.setNifPasaporte("");
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExterno result = fixture.getUsuarioExternoFromView(session, name, view);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.AltaUsuarioService.getUsuarioExternoFromView(AltaUsuarioService.java:91)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExterno getUsuarioExternoFromView(Session,String,UsuarioExternoView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExternoFromView_3()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String name = "";
		UsuarioExternoView view = new UsuarioExternoView();
		view.setLocalidad("");
		view.setDireccion("");
		view.setCodigoPostal("");
		view.setTelefono("");
		view.setNombre("");
		view.setMail("");
		view.setApellido2("");
		view.setIdentificador("");
		view.setObservaciones("");
		view.setApellido1("");
		view.setNifPasaporte("");
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExterno result = fixture.getUsuarioExternoFromView(session, name, view);

		// add additional test code here
		EasyMock.verify(session);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.service.AltaUsuarioService.getUsuarioExternoFromView(AltaUsuarioService.java:91)
		assertNotNull(result);
	}

	/**
	 * Run the UsuarioExternoView getViewFromUsuarioExterno(UsuarioExterno) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetViewFromUsuarioExterno_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		UsuarioExterno usuarioExterno = new UsuarioExterno(new Biblioteca(), new Usuario(), "", "", "", "", "", "", "", "", "", "", "", new Date());
		usuarioExterno.setFoto("");

		UsuarioExternoView result = fixture.getViewFromUsuarioExterno(usuarioExterno);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getIdentificador());
		assertEquals(null, result.getBiblioteca());
		assertEquals("", result.getNombre());
		assertEquals("", result.getFoto());
		assertEquals("", result.getMail());
		assertEquals("", result.getApellido2());
		assertEquals("", result.getNifPasaporte());
		assertEquals("", result.getTelefono());
		assertEquals("", result.getDireccion());
		assertEquals("", result.getLocalidad());
		assertEquals("", result.getCodigoPostal());
		assertEquals("", result.getObservaciones());
		assertEquals("", result.getApellido1());
	}

	/**
	 * Run the List<UsuarioExterno> list() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testList_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();

		List<UsuarioExterno> result = fixture.list();

		// add additional test code here
		assertEquals(null, result);
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
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		Session session = org.easymock.EasyMock.createMock(Session.class);
		UsuarioExterno usuarioExterno = new UsuarioExterno();
		// add mock object expectations here

		EasyMock.replay(session);

		fixture.persist(session, usuarioExterno);

		// add additional test code here
		EasyMock.verify(session);
	}

	/**
	 * Run the void setBibliotecaDao(BibliotecaDao) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testSetBibliotecaDao_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		BibliotecaDao bibliotecaDao = EasyMock.createMock(BibliotecaDao.class);
		// add mock object expectations here

		EasyMock.replay(bibliotecaDao);

		fixture.setBibliotecaDao(bibliotecaDao);

		// add additional test code here
		EasyMock.verify(bibliotecaDao);
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
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		UsuarioDao usuarioDao = EasyMock.createMock(UsuarioDao.class);
		// add mock object expectations here

		EasyMock.replay(usuarioDao);

		fixture.setUsuarioDao(usuarioDao);

		// add additional test code here
		EasyMock.verify(usuarioDao);
	}

	/**
	 * Run the void setUsuarioExternoDao(UsuarioExternoDao) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testSetUsuarioExternoDao_1()
		throws Exception {
		AltaUsuarioService fixture = new AltaUsuarioService();
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setBibliotecaDao(EasyMock.createNiceMock(BibliotecaDao.class));
		fixture.log = Logger.getAnonymousLogger();
		UsuarioExternoDao usuarioExternoDao = EasyMock.createMock(UsuarioExternoDao.class);
		// add mock object expectations here

		EasyMock.replay(usuarioExternoDao);

		fixture.setUsuarioExternoDao(usuarioExternoDao);

		// add additional test code here
		EasyMock.verify(usuarioExternoDao);
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
		new org.junit.runner.JUnitCore().run(AltaUsuarioServiceTest.class);
	}
}