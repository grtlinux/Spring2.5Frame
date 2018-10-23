package kame.spring.chap04.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SubmitReportValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return SubmitReportCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils
				.rejectIfEmptyOrWhitespace(errors, "subject", "required");
		SubmitReportCommand command = (SubmitReportCommand) target;
		if (command.getReportFile() == null
				|| command.getReportFile().isEmpty())
			errors.rejectValue("reportFile", "required");
		if (command.getSourceCode() == null
				|| command.getSourceCode().length == 0)
			errors.rejectValue("sourceCode", "required");
	}

}
