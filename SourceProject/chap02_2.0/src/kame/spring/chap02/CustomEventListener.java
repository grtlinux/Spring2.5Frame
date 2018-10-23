package kame.spring.chap02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof CustomEvent) {
			log.info("CustomEvent occured:source=" + event.getSource());
		}
	}

}
