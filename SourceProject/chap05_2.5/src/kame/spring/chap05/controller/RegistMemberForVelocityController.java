package kame.spring.chap05.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegistMemberForVelocityController extends SimpleFormController {

	public RegistMemberForVelocityController() {
		setCommandClass(MemberInfo.class);
		setCommandName("memberInfo");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Map<String, String> jobCodes = new HashMap<String, String>();
		jobCodes.put("1", "������");
		jobCodes.put("2", "UI ������");
		jobCodes.put("3", "�� �����̳�");
		jobCodes.put("4", "��ȹ��");

		Map<String, String> favoritesOsNames = new HashMap<String, String>();
		favoritesOsNames.put("WIN2000", "������2000");
		favoritesOsNames.put("WINXP", "������XP");
		favoritesOsNames.put("VISTA", "��Ÿ");
		favoritesOsNames.put("UBUNTU", "�����");
		favoritesOsNames.put("MAC", "��");
		
		Map<String, String> tools = new HashMap<String, String>();
		tools.put("Eclipse", "Eclipse");
		tools.put("IntelliJ", "IntelliJ");
		tools.put("NetBeans", "NetBeans");

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
