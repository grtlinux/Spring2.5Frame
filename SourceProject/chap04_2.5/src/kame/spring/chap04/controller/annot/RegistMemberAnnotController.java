package kame.spring.chap04.controller.annot;

import javax.servlet.http.HttpServletRequest;

import kame.spring.chap04.controller.Address;
import kame.spring.chap04.controller.MemberInfo;
import kame.spring.chap04.controller.MemberInfoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/annot/registMember.do")
@SessionAttributes("memberInfo")
public class RegistMemberAnnotController {
	private Validator validator = new MemberInfoValidator();

	@ModelAttribute("memberInfo")
	public MemberInfo formBacking(HttpServletRequest reqeust) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setAddress(new Address());
		return memberInfo;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "registMemberFormUseAnnot";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmitForm(@ModelAttribute("memberInfo")
	MemberInfo command, BindingResult errors, SessionStatus sessionStatus) {
		validator.validate(command, errors);
		if (errors.hasErrors()) {
			return showForm();
		}
		// 로직 처리
		sessionStatus.setComplete();
		return "registMember";
	}
}
