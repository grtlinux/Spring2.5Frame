package kame.spring.chap05.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		if (LoginCommand.class.isAssignableFrom(clazz))
			return true;
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand command = (LoginCommand) target;
		if (isEmpty(command.getId())) {
			errors.rejectValue("id", "required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required");
		if (isEmpty(command.getLoginType())) {
			errors.rejectValue("loginType", "required");
		}
	}

	private boolean isEmpty(String value) {
		if (value == null || value.length() == 0) {
			return true;
		}
		return false;
	}

}
