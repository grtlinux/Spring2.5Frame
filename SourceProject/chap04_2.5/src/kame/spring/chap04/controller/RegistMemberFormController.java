package kame.spring.chap04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RegistMemberFormController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setAddress(new Address());
		return new ModelAndView("registMemberForm", "memberInfo", memberInfo);
	}

}
