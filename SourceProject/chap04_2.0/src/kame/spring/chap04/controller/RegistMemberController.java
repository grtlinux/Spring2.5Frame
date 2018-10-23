package kame.spring.chap04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class RegistMemberController extends AbstractCommandController {

	public RegistMemberController() {
		setCommandClass(MemberInfo.class);
		setCommandName("memberInfo");
	}

	@Override
	protected Object getCommand(HttpServletRequest request) throws Exception {
		MemberInfo member = (MemberInfo) super.getCommand(request);
		member.setAddress(new Address());
		return member;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		if (errors.hasErrors()) {
			return new ModelAndView("registMemberForm", errors.getModel());
		} else {
			return new ModelAndView("registMember", getCommandName(), command);
		}
	}

}
