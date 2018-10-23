package kame.spring.bbs.domain.notification;

import kame.spring.bbs.domain.model.Member;
import kame.spring.bbs.domain.service.MemberRegistrationEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public abstract class AbstractRegistrationNotifier implements
		ApplicationListener {

	private Log log = LogFactory.getLog(getClass());
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof MemberRegistrationEvent) {
			if (log.isDebugEnabled()) {
				log.debug("MemberRegistrationEvent received.");
			}
			MemberRegistrationEvent memberEvent = (MemberRegistrationEvent) event;
			sendEmailTo(memberEvent.getMember());
		}
	}

	protected abstract void sendEmailTo(Member member);
}
