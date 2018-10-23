package kame.spring.chap04.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class HomepageRegistryPage0Validator extends
		AbstractHomepageRegistryValidator {

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homepageUrl",
				"required");
		HomepageRegistryCommand command = (HomepageRegistryCommand) target;
		if (command.getHomepageUrl() != null) {
			if (command.getHomepageUrl().trim().equals("http://")) {
				errors.rejectValue("homepageUrl", "invalidValue");
			}
		}
	}

}
