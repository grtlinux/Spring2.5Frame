package kame.spring.chap04.controller.annot;

import java.util.ArrayList;
import java.util.List;

import kame.spring.chap04.controller.AuthenticationException;
import kame.spring.chap04.controller.Authenticator;
import kame.spring.chap04.controller.LoginCommand;
import kame.spring.chap04.controller.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/annot/login.do")
public class LoginAnnotController {
	private Authenticator authenticator;
	private String formView = "loginForm";
	private String successView = "loginSuccess";
	private LoginCommandValidator validator = new LoginCommandValidator();

	@Autowired
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	public String getFormView() {
		return formView;
	}

	public void setFormView(String formView) {
		this.formView = formView;
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	@ModelAttribute("loginTypes")
	public List<String> getLoginTypes() {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap map) {
		return getFormView();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("login")
	LoginCommand loginCommand, BindingResult errors, ModelMap model) {
		validator.validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return getFormView();
		}
		try {
			authenticator.authenticate(loginCommand.getId(), loginCommand
					.getPassword());
			return getSuccessView();
		} catch (AuthenticationException ex) {
			errors.reject("invalidIdOrPassword", new Object[] { loginCommand
					.getId() }, null);
			return getFormView();
		}
	}

}
