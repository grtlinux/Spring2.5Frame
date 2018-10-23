package kame.spring.bbs.domain.service;

import kame.spring.bbs.domain.model.Member;

import org.springframework.context.ApplicationEvent;

public class MemberRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private Member member;

	public MemberRegistrationEvent(Object source, Member member) {
		super(source);
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

}
