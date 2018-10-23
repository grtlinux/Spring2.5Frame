package kame.spring.chap04.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController {

	private Authenticator authenticator;

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		LoginCommand loginCommand = (LoginCommand) command;
		try {
			authenticator.authenticate(loginCommand.getId(), loginCommand
					.getPassword());
			ModelAndView mav = new ModelAndView();
			mav.setViewName(getSuccessView());
			mav.addAllObjects(errors.getModel());
			return mav;
		} catch (AuthenticationException ex) {
			errors.reject("invalidIdOrPassword", new Object[] { loginCommand
					.getId() }, null);
			return showForm(request, response, errors);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");

		Map reference = new HashMap();
		reference.put("loginTypes", loginTypes);
		return reference;
	}

}
