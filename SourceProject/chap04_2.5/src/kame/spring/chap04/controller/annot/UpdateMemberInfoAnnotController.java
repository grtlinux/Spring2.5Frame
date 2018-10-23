package kame.spring.chap04.controller.annot;

import javax.servlet.http.HttpServletRequest;

import kame.spring.chap04.controller.Address;
import kame.spring.chap04.controller.MemberInfo;
import kame.spring.chap04.controller.MemberInfoRetrievalService;
import kame.spring.chap04.controller.UpdateMemberInfoValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/annot/updateMemberInfo.do")
public class UpdateMemberInfoAnnotController {
	@Autowired
	private MemberInfoRetrievalService memberInfoRetrievalService;

	private Validator validator = new UpdateMemberInfoValidator();
	
	public void setMemberInfoRetrievalService(
			MemberInfoRetrievalService getMemberService) {
		this.memberInfoRetrievalService = getMemberService;
	}

	@ModelAttribute("memberInfo")
	protected MemberInfo formBackingObject(HttpServletRequest request)
			throws Exception {
		String userId = null;
		if (!isFormSubmission(request)) {
			MemberInfo memberInfo = memberInfoRetrievalService
					.getMemberInfo(userId);
			return memberInfo;
		} else {
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setAddress(new Address());
			return memberInfo;
		}
	}

	private boolean isFormSubmission(HttpServletRequest request) {
		return "POST".equals(request.getMethod());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewForm() {
		return showForm();
	}
	
	public String showForm() {
		return "updateMemberInfoFormUseAnnot";
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String processFormSubmit(@ModelAttribute("memberInfo")
	MemberInfo command, BindingResult errors) throws Exception {
		validator.validate(command, errors);
		if (errors.hasErrors()) {
			return showForm();
		} else {
			return "updateMemberInfo";
		}
	}

}
