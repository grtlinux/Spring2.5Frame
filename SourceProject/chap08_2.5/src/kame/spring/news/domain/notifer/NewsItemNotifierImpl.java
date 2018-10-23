package kame.spring.news.domain.notifer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import kame.spring.news.domain.model.NewsItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class NewsItemNotifierImpl extends JmsGatewaySupport implements
		NewsItemNotifier {

	private Log log = LogFactory.getLog(getClass());
	
	@Override
	public void notify(final NewsItem newsItem) {
		getJmsTemplate().send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setString("subject", newsItem.getSubject());
				return mapMessage;
			}
		});
		log.debug("notify() 정상적으로 실행:"+newsItem.getSubject());
	}

}
