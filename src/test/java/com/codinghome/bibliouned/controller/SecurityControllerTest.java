package com.codinghome.bibliouned.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.easymock.classextension.EasyMock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;
import com.codinghome.bibliouned.service.UserService;
import junit.framework.*;

/**
 * The class <code>SecurityControllerTest</code> contains tests for the class <code>{@link SecurityController}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05, using the Spring generator
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class SecurityControllerTest extends TestCase {
	/**
	 * Run the SecurityController() constructor test.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testSecurityController_1()
		throws Exception {
		SecurityController result = new SecurityController();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the ModelAndView accesssDenied() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testAccesssDenied_1()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));

		ModelAndView result = fixture.accesssDenied();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.SecurityController.accesssDenied(SecurityController.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView accesssDenied() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testAccesssDenied_2()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));

		ModelAndView result = fixture.accesssDenied();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.codinghome.bibliouned.controller.SecurityController.accesssDenied(SecurityController.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the ModelAndView login(String,String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testLogin_1()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));
		String error = (String) null;
		String logout = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.login(error, logout, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		assertNotNull("ModelAndView should not be null", result);
		ModelAndViewAssert.assertViewName(result, "login");
	}

	/**
	 * Run the ModelAndView login(String,String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testLogin_2()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));
		String error = (String) null;
		String logout = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.login(error, logout, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		assertNotNull("ModelAndView should not be null", result);
		ModelAndViewAssert.assertViewName(result, "login");
	}

	/**
	 * Run the ModelAndView login(String,String,HttpServletRequest,Principal) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testLogin_3()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));
		String error = (String) null;
		String logout = (String) null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		Principal principal = org.easymock.EasyMock.createMock(Principal.class);
		// add mock object expectations here

		EasyMock.replay(principal);

		ModelAndView result = fixture.login(error, logout, request, principal);

		// add additional test code here
		EasyMock.verify(principal);
		assertNotNull("ModelAndView should not be null", result);
		ModelAndViewAssert.assertViewName(result, "login");
	}

	/**
	 * Run the ModelAndView navigationBar(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testNavigationBar_1()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));
		String mainPage = (String) null;

		ModelAndView result = fixture.navigationBar(mainPage);

		// add additional test code here
		assertNotNull("ModelAndView should not be null", result);
		ModelAndViewAssert.assertViewName(result, "navigation");
	}

	/**
	 * Run the ModelAndView navigationBar(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testNavigationBar_2()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));
		String mainPage = (String) null;

		ModelAndView result = fixture.navigationBar(mainPage);

		// add additional test code here
		assertNotNull("ModelAndView should not be null", result);
		ModelAndViewAssert.assertViewName(result, "navigation");
	}

	/**
	 * Run the ModelAndView navigationBar(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public void testNavigationBar_3()
		throws Exception {
		SecurityController fixture = new SecurityController();
		fixture.setUserService(EasyMock.createNiceMock(UserService.class));
		String mainPage = (String) null;

		ModelAndView result = fixture.navigationBar(mainPage);

		// add additional test code here
		assertNotNull("ModelAndView should not be null", result);
		ModelAndViewAssert.assertViewName(result, "navigation");
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
			junit.textui.TestRunner.run(SecurityControllerTest.class);
		} else {
			// Run only the named tests
			TestSuite suite = new TestSuite("Selected tests");
			for (int i = 0; i < args.length; i++) {
				TestCase test = new SecurityControllerTest();
				test.setName(args[i]);
				suite.addTest(test);
			}
			junit.textui.TestRunner.run(suite);
		}
	}
}