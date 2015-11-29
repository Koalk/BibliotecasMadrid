package com.codinghome.bibliouned.controller;

import java.security.Principal;

import javax.servlet.ServletContext;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.easymock.classextension.EasyMock;
import org.hibernate.SessionFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.codinghome.bibliouned.MockingUtils;
import com.codinghome.bibliouned.service.AltaUsuarioService;
import com.codinghome.bibliouned.view.UsuarioExternoView;

/**
 * The class <code>AltaUsuarioControllerTest</code> contains tests for the class <code>{@link AltaUsuarioController}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05, using the Spring generator
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class AltaUsuarioControllerTest extends TestCase {
	/**
	 * Run the AltaUsuarioController() constructor test.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testAltaUsuarioController_1()
		throws Exception {
		AltaUsuarioController result = new AltaUsuarioController();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void initBinder(WebDataBinder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testInitBinder_1()
		throws Exception {
		AltaUsuarioController fixture = new AltaUsuarioController();
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		fixture.setServletContext(org.easymock.EasyMock.createNiceMock(ServletContext.class));
		fixture.setAltaUsuarioService(EasyMock.createNiceMock(AltaUsuarioService.class));
		WebDataBinder binder = new WebDataBinder(new Object());

		fixture.initBinder(binder);

		// add additional test code here
	}

	/**
	 * Run the ModelAndView newExternalUser(String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testNewExternalUser_OK()
		throws Exception {
		AltaUsuarioController fixture = new AltaUsuarioController();
		fixture.setSessionFactory(MockingUtils.getSessionFactoryMock());
		fixture.setServletContext(org.easymock.EasyMock.createNiceMock(ServletContext.class));
		fixture.setAltaUsuarioService(EasyMock.createNiceMock(AltaUsuarioService.class));
		String identificador = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.newExternalUser(identificador, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.AltaUsuarioController.newExternalUser(AltaUsuarioController.java:85)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView saveExternalUser(HttpServletRequest,Principal,UsuarioExternoView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSaveExternalUser_OK()
		throws Exception {
		AltaUsuarioController fixture = new AltaUsuarioController();
		fixture.setSessionFactory(MockingUtils.getSessionFactoryMock());
		fixture.setServletContext(org.easymock.EasyMock.createNiceMock(ServletContext.class));
		fixture.setAltaUsuarioService(EasyMock.createNiceMock(AltaUsuarioService.class));
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		UsuarioExternoView externalUser = new UsuarioExternoView();
		externalUser.setFoto((String) null);
		externalUser.setNifPasaporte("");
		BindingResult result = MockingUtils.getResultWithoutErrors();
		// add mock object expectations here

		EasyMock.replay(principal);
		EasyMock.replay(result);

		ModelAndView result2 = fixture.saveExternalUser(request, principal, externalUser, result);

		// add additional test code here
		EasyMock.verify(principal);
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.AltaUsuarioController.saveExternalUser(AltaUsuarioController.java:132)
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
			junit.textui.TestRunner.run(AltaUsuarioControllerTest.class);
		} else {
			// Run only the named tests
			TestSuite suite = new TestSuite("Selected tests");
			for (int i = 0; i < args.length; i++) {
				TestCase test = new AltaUsuarioControllerTest();
				test.setName(args[i]);
				suite.addTest(test);
			}
			junit.textui.TestRunner.run(suite);
		}
	}
}