package kame.spring.chap04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdateMemberInfoController extends SimpleFormController {

	private MemberInfoRetrievalService memberInfoRetrievalService;

	public UpdateMemberInfoController() {
		setCommandClass(MemberInfo.class);
		setCommandName("memberInfo");
	}

	public void setMemberInfoRetrievalService(
			MemberInfoRetrievalService getMemberService) {
		this.memberInfoRetrievalService = getMemberService;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String userId = null;
		if (!isFormSubmission(request)) { // HTTP POST 요청이 아니면
			MemberInfo memberInfo = memberInfoRetrievalService
					.getMemberInfo(userId);
			return memberInfo;
		} else {
			MemberInfo memberInfo = (MemberInfo)super.formBackingObject(request);
			memberInfo.setAddress(new Address());
			return memberInfo;
		}
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		// MemberInfo memberInfo = (MemberInfo) command;
		return super.onSubmit(command);
	}

}
