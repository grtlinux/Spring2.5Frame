package kame.spring.search.bbs;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import kame.spring.bbs.domain.model.Article;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.support.JmsUtils;

public class ArticleMessageListener implements MessageListener {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			Article article = new Article();
			article.setSubject(mapMessage.getString("subject"));
			processReceiveArtice(article);
		} catch (JMSException e) {
			log.error("MapMessage���� subject �� ���� ����", e);
			throw JmsUtils.convertJmsAccessException(e);
		}
	}

	private void processReceiveArtice(Article article) {
		log.debug("Article ���� ó�� ��û:"+article.getSubject());
	}

}
