package kame.spring.chap04.controller;

import org.springframework.validation.Validator;

public abstract class AbstractHomepageRegistryValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		if (HomepageRegistryCommand.class.isAssignableFrom(clazz)) {
			return true;
		}
		return false;
	}

}
