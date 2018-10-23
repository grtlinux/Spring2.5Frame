package kame.spring.bbs.domain.service;

import kame.spring.bbs.domain.model.Member;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RegistrationServiceImpl implements RegistrationService,
		ApplicationContextAware {

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}

	@Override
	public void regist(Member member) {
		context.publishEvent(new MemberRegistrationEvent(this, member));
	}

}
