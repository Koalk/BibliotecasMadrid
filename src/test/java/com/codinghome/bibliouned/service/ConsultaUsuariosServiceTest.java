package com.codinghome.bibliouned.service;

import java.util.List;
import org.easymock.classextension.EasyMock;
import org.hibernate.Session;
import org.junit.*;
import static org.junit.Assert.*;
import com.codinghome.bibliouned.dao.UsuarioDao;
import com.codinghome.bibliouned.dao.UsuarioExternoDao;
import com.codinghome.bibliouned.model.UsuarioExterno;
import com.codinghome.bibliouned.view.UsuarioExternoView;

/**
 * The class <code>ConsultaUsuariosServiceTest</code> contains tests for the class <code>{@link ConsultaUsuariosService}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class ConsultaUsuariosServiceTest {
	/**
	 * Run the List<UsuarioExterno> findUsuariosExternos(Session,UsuarioExternoView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testFindUsuariosExternos_1()
		throws Exception {
		ConsultaUsuariosService fixture = new ConsultaUsuariosService();
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		Session session = org.easymock.EasyMock.createMock(Session.class);
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		// add mock object expectations here

		EasyMock.replay(session);

		List<UsuarioExterno> result = fixture.findUsuariosExternos(session, usuarioExterno);

		// add additional test code here
		EasyMock.verify(session);
		assertEquals(null, result);
	}

	/**
	 * Run the UsuarioExternoView getUsuarioExterno(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExterno_1()
		throws Exception {
		ConsultaUsuariosService fixture = new ConsultaUsuariosService();
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExternoView result = fixture.getUsuarioExterno(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		assertNotNull(result);
		assertEquals(null, result.getIdentificador());
		assertEquals(null, result.getBiblioteca());
		assertEquals(null, result.getNombre());
		assertEquals(null, result.getFoto());
		assertEquals(null, result.getMail());
		assertEquals(null, result.getApellido2());
		assertEquals(null, result.getNifPasaporte());
		assertEquals(null, result.getTelefono());
		assertEquals(null, result.getDireccion());
		assertEquals(null, result.getLocalidad());
		assertEquals(null, result.getCodigoPostal());
		assertEquals(null, result.getObservaciones());
		assertEquals(null, result.getApellido1());
	}

	/**
	 * Run the UsuarioExternoView getUsuarioExterno(Session,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	@Test
	public void testGetUsuarioExterno_2()
		throws Exception {
		ConsultaUsuariosService fixture = new ConsultaUsuariosService();
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
		Session session = org.easymock.EasyMock.createMock(Session.class);
		String identificador = "";
		// add mock object expectations here

		EasyMock.replay(session);

		UsuarioExternoView result = fixture.getUsuarioExterno(session, identificador);

		// add additional test code here
		EasyMock.verify(session);
		assertNotNull(result);
		assertEquals(null, result.getIdentificador());
		assertEquals(null, result.getBiblioteca());
		assertEquals(null, result.getNombre());
		assertEquals(null, result.getFoto());
		assertEquals(null, result.getMail());
		assertEquals(null, result.getApellido2());
		assertEquals(null, result.getNifPasaporte());
		assertEquals(null, result.getTelefono());
		assertEquals(null, result.getDireccion());
		assertEquals(null, result.getLocalidad());
		assertEquals(null, result.getCodigoPostal());
		assertEquals(null, result.getObservaciones());
		assertEquals(null, result.getApellido1());
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
		ConsultaUsuariosService fixture = new ConsultaUsuariosService();
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
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
		ConsultaUsuariosService fixture = new ConsultaUsuariosService();
		fixture.setUsuarioExternoDao(EasyMock.createNiceMock(UsuarioExternoDao.class));
		fixture.setUsuarioDao(EasyMock.createNiceMock(UsuarioDao.class));
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
		new org.junit.runner.JUnitCore().run(ConsultaUsuariosServiceTest.class);
	}
}