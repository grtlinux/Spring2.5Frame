package kame.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import kame.spring.controller.LoginCommand;
import kame.spring.controller.LoginConroller;
import kame.spring.controller.MockAuthenticator;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

public class LoginControllerTest extends TestCase {

	private LoginConroller loginController;
	private MockHttpServletRequest request = new MockHttpServletRequest();
	private MockHttpServletResponse response = new MockHttpServletResponse();

	@Override
	protected void setUp() throws Exception {
		loginController = new LoginConroller();
		loginController.setFormView("loginForm");
		loginController.setSuccessView("loginSuccess");
		loginController.setAuthenticator(new MockAuthenticator());
	}

	@SuppressWarnings("unchecked")
	public void testGet() {
		List<String> expectedLoginTypes = new ArrayList<String>();
		expectedLoginTypes.add("일반회원");
		expectedLoginTypes.add("기업회원");
		expectedLoginTypes.add("헤드헌터회원");

		request.setMethod("GET");
		try {
			ModelAndView mav = loginController.handleRequest(request, response);
			assertEquals(loginController.getFormView(), mav.getViewName());
			List<String> modelLoginTypes = (List<String>) mav.getModel().get(
					"loginTypes");
			assertNotNull(modelLoginTypes);
			assertEquals(expectedLoginTypes.size(), modelLoginTypes.size());
			for (int i = 0 ; i < expectedLoginTypes.size() ; i++) {
				assertEquals(expectedLoginTypes.get(i), modelLoginTypes.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testValidLogin() {
		String validId = "madvirus";
		request.setMethod("POST");
		request.addParameter("id", validId);
		request.addParameter("password", "password");
		request.addParameter("loginType", "일반회원");
		try {
			ModelAndView mav = loginController.handleRequest(request, response);
			assertEquals(loginController.getSuccessView(), mav.getViewName());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void testInvalidLogin() {
		String invalidId = "madvirus2";
		request.setMethod("POST");
		request.addParameter("id", invalidId);
		request.addParameter("password", "password");
		request.addParameter("loginType", "일반회원");
		try {
			ModelAndView mav = loginController.handleRequest(request, response);
			assertEquals(loginController.getFormView(), mav.getViewName());
			Map model = mav.getModel();
			LoginCommand command = (LoginCommand) model.get(loginController
					.getCommandName());
			assertNotNull(command);
			assertEquals(invalidId, command.getId());

			BindingResult result = (BindingResult) model
					.get(BindingResult.MODEL_KEY_PREFIX
							+ loginController.getCommandName());
			assertNotNull(result);
			assertTrue(result.hasGlobalErrors());
			assertEquals(1, result.getGlobalErrors().size());
			ObjectError error = (ObjectError) result.getGlobalErrors().get(0);

			String value = "invalidIdOrPassword";
			for (String code : error.getCodes()) {
				assertTrue(code.contains(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
