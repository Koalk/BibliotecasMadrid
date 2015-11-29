package com.codinghome.bibliouned.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.easymock.classextension.EasyMock;
import org.hibernate.SessionFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import com.codinghome.bibliouned.service.ConfiguracionService;
import com.codinghome.bibliouned.view.UsuarioView;
import junit.framework.*;

/**
 * The class <code>ConfiguracionControllerTest</code> contains tests for the class <code>{@link ConfiguracionController}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05, using the Spring generator
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class ConfiguracionControllerTest extends TestCase {
	/**
	 * Run the void initBinder(WebDataBinder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testInitBinder_1()
		throws Exception {
		ConfiguracionController fixture = new ConfiguracionController();
		fixture.setConfiguracionService(EasyMock.createNiceMock(ConfiguracionService.class));
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		WebDataBinder binder = new WebDataBinder(new Object());

		fixture.initBinder(binder);

		// add additional test code here
	}

	/**
	 * Run the ModelAndView saveUsuarioExterno(HttpServletRequest,Principal,UsuarioView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSaveUsuarioExterno_1()
		throws Exception {
		ConfiguracionController fixture = new ConfiguracionController();
		fixture.setConfiguracionService(EasyMock.createNiceMock(ConfiguracionService.class));
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		UsuarioView user = new UsuarioView();
		BindingResult result = org.easymock.EasyMock.createMock(BindingResult.class);
		// add mock object expectations here

		EasyMock.replay(principal);
		EasyMock.replay(result);

		ModelAndView result2 = fixture.saveUsuarioExterno(request, principal, user, result);

		// add additional test code here
		EasyMock.verify(principal);
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConfiguracionController.saveUsuarioExterno(ConfiguracionController.java:98)
		assertNotNull(result2);
	}

	/**
	 * Run the ModelAndView saveUsuarioExterno(HttpServletRequest,Principal,UsuarioView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSaveUsuarioExterno_2()
		throws Exception {
		ConfiguracionController fixture = new ConfiguracionController();
		fixture.setConfiguracionService(EasyMock.createNiceMock(ConfiguracionService.class));
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		UsuarioView user = new UsuarioView();
		BindingResult result = org.easymock.EasyMock.createMock(BindingResult.class);
		// add mock object expectations here

		EasyMock.replay(principal);
		EasyMock.replay(result);

		ModelAndView result2 = fixture.saveUsuarioExterno(request, principal, user, result);

		// add additional test code here
		EasyMock.verify(principal);
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConfiguracionController.saveUsuarioExterno(ConfiguracionController.java:98)
		assertNotNull(result2);
	}

	/**
	 * Run the ModelAndView saveUsuarioExterno(HttpServletRequest,Principal,UsuarioView,BindingResult) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSaveUsuarioExterno_3()
		throws Exception {
		ConfiguracionController fixture = new ConfiguracionController();
		fixture.setConfiguracionService(EasyMock.createNiceMock(ConfiguracionService.class));
		fixture.setSessionFactory(org.easymock.EasyMock.createNiceMock(SessionFactory.class));
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		UsuarioView user = new UsuarioView();
		BindingResult result = org.easymock.EasyMock.createMock(BindingResult.class);
		// add mock object expectations here

		EasyMock.replay(principal);
		EasyMock.replay(result);

		ModelAndView result2 = fixture.saveUsuarioExterno(request, principal, user, result);

		// add additional test code here
		EasyMock.verify(principal);
		EasyMock.verify(result);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.ConfiguracionController.saveUsuarioExterno(ConfiguracionController.java:98)
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
			junit.textui.TestRunner.run(ConfiguracionControllerTest.class);
		} else {
			// Run only the named tests
			TestSuite suite = new TestSuite("Selected tests");
			for (int i = 0; i < args.length; i++) {
				TestCase test = new ConfiguracionControllerTest();
				test.setName(args[i]);
				suite.addTest(test);
			}
			junit.textui.TestRunner.run(suite);
		}
	}
}