package kame.spring.chap05.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegistMemberController extends SimpleFormController {

	public RegistMemberController() {
		setCommandClass(MemberInfo.class);
		setCommandName("memberInfo");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		List<Code> jobCodes = new ArrayList<Code>();
		jobCodes.add(new Code("1", "개발자"));
		jobCodes.add(new Code("2", "UI 개발자"));
		jobCodes.add(new Code("3", "웹 디자이너"));
		jobCodes.add(new Code("3", "기획자"));

		String[] favoritesOsNames = { "윈도우2000", "윈도우XP", "비스타", "우분투", "맥" };
		String[] tools = { "Eclipse", "IntelliJ", "NetBeans" };

		Map<String, Object> referenceData = new HashMap<String, Object>();
		referenceData.put("jobCodes", jobCodes);
		referenceData.put("favoritesOsNames", favoritesOsNames);
		referenceData.put("tools", tools);

		return referenceData;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		MemberInfo member = new MemberInfo();
		member.setAddress(new Address());
		return member;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		checkDuplicateId(((MemberInfo) command).getUserId(), errors);
		if (errors.hasErrors()) {
			return showForm(request, response, errors);
		}
		return new ModelAndView(getSuccessView(), errors.getModel());
	}

	private void checkDuplicateId(String userId, BindException errors) {
		if (userId.equals("madvirus")) {
			errors.rejectValue("userId", "duplicate");
		}
	}

}
