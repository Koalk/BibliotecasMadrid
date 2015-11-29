package com.codinghome.bibliouned.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.easymock.classextension.EasyMock;
import org.hibernate.SessionFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import com.codinghome.bibliouned.service.ConsultaUsuariosService;
import com.codinghome.bibliouned.view.UsuarioExternoView;
import junit.framework.*;

/**
 * The class <code>ConsultaUsuariosControllerTest</code> contains tests for the class <code>{@link ConsultaUsuariosController}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05, using the Spring generator
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class ConsultaUsuariosControllerTest extends TestCase {
	/**
	 * Run the ModelAndView externalUserView(String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testExternalUserView_1()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		String identificador = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.externalUserView(identificador, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.externalUserView(ConsultaUsuariosController.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView externalUserView(String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testExternalUserView_2()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		String identificador = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.externalUserView(identificador, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.externalUserView(ConsultaUsuariosController.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView externalUserView(String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testExternalUserView_3()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		String identificador = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.externalUserView(identificador, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.externalUserView(ConsultaUsuariosController.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView externalUserView(String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testExternalUserView_4()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		String identificador = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.externalUserView(identificador, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.externalUserView(ConsultaUsuariosController.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView searchExternalUsers(UsuarioExternoView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSearchExternalUsers_1()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		BindingResult result = org.easymock.EasyMock.createMock(BindingResult.class);
		// add mock object expectations here

		EasyMock.replay(result);

		ModelAndView result2 = fixture.searchExternalUsers(usuarioExterno, result);

		// add additional test code here
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.searchExternalUsers(ConsultaUsuariosController.java:78)
		assertNotNull(result2);
	}

	/**
	 * Run the ModelAndView searchExternalUsers(UsuarioExternoView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSearchExternalUsers_2()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		BindingResult result = org.easymock.EasyMock.createMock(BindingResult.class);
		// add mock object expectations here

		EasyMock.replay(result);

		ModelAndView result2 = fixture.searchExternalUsers(usuarioExterno, result);

		// add additional test code here
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.searchExternalUsers(ConsultaUsuariosController.java:78)
		assertNotNull(result2);
	}

	/**
	 * Run the ModelAndView searchExternalUsers(UsuarioExternoView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSearchExternalUsers_3()
		throws Exception {
		ConsultaUsuariosController fixture = new ConsultaUsuariosController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setConsultaUsuariosService(EasyMock.createNiceMock(ConsultaUsuariosService.class));
		UsuarioExternoView usuarioExterno = new UsuarioExternoView();
		BindingResult result = org.easymock.EasyMock.createMock(BindingResult.class);
		// add mock object expectations here

		EasyMock.replay(result);

		ModelAndView result2 = fixture.searchExternalUsers(usuarioExterno, result);

		// add additional test code here
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConsultaUsuariosController.searchExternalUsers(ConsultaUsuariosController.java:78)
		assertNotNull(result2);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @see TestCase#setUp()
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	protected void setUp()
		throws Exception {
		super.setUp();
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @see TestCase#tearDown()
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	protected void tearDown()
		throws Exception {
		super.tearDown();
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
		if (args.length == 0) {
			// Run all of the tests
			junit.textui.TestRunner.run(ConsultaUsuariosControllerTest.class);
		} else {
			// Run only the named tests
			TestSuite suite = new TestSuite("Selected tests");
			for (int i = 0; i < args.length; i++) {
				TestCase test = new ConsultaUsuariosControllerTest();
				test.setName(args[i]);
				suite.addTest(test);
			}
			junit.textui.TestRunner.run(suite);
		}
	}
}