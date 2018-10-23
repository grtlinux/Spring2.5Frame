package kame.spring.chap04.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class HomepageRegistryPage1Validator extends
		AbstractHomepageRegistryValidator {

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"required");
	}

}
