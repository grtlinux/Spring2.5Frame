package kame.spring.chap04.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

public class HomepageRegistryController extends AbstractWizardFormController {

	public HomepageRegistryController() {
		setCommandClass(HomepageRegistryCommand.class);
		setCommandName("registry");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		HomepageRegistryCommand command = (HomepageRegistryCommand) super
				.formBackingObject(request);
		command.setHomepageUrl("http://");
		return command;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors, int page) throws Exception {
		if (page == 1) {
			// 1 페이지에서 필요로 하는 데이터
			List<String> types = new ArrayList<String>();
			types.add("기업");
			types.add("개인/블로그");

			Map reference = new HashMap();
			reference.put("types", types);
			return reference;
		}
		return null;
	}

	@Override
	protected void validatePage(Object command, Errors errors, int page,
			boolean finish) {
		if (page == 0) {
			ValidationUtils
					.invokeValidator(getValidators()[0], command, errors);
		} else if (page == 1) {
			ValidationUtils
					.invokeValidator(getValidators()[1], command, errors);
		}
	}

	@Override
	protected void postProcessPage(HttpServletRequest request, Object command,
			Errors errors, int page) throws Exception {
		HomepageRegistryCommand registry = (HomepageRegistryCommand) command;
		if (page == 0) {
			// 0 페이지에서 submit 한 경우의 처리
			if (!checkDuplicate(registry)) {
				errors.rejectValue("homepageUrl", "duplicate");
			}
		} else if (page == 1) {
			// 1 페이지에서 submit 한 경우의 처리
		}
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		HomepageRegistryCommand registry = (HomepageRegistryCommand) command;
		if (registry.getType().equals("기업")) {
			errors.rejectValue("type", "not_supported");
			return showPage(request, errors, 1);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getPages()[getPageCount() - 1]);
		mav.addObject("registry", registry);
		return mav;
	}

	private boolean checkDuplicate(HomepageRegistryCommand registry) {
		if (registry.getHomepageUrl().equals("http://javacan.madvirus.net")) {
			return false;
		}
		return true;
	}

	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		return new ModelAndView("homepageRegistryCancel", errors.getModel());
	}

}
