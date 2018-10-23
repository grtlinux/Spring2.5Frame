package kame.spring.bbs.domain.notification;

import javax.jms.Destination;

import kame.spring.bbs.domain.model.Article;
import kame.spring.bbs.domain.service.ArticleCreationEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jms.core.JmsTemplate;

public class ArticleMessageSender implements ApplicationListener {

	private Log log = LogFactory.getLog(getClass());
	
	private JmsTemplate jmsTemplate;
	private Destination destination;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ArticleCreationEvent) {
			ArticleCreationEvent e = (ArticleCreationEvent) event;
			Article article = e.getArticle();
			sendMessage(article);
		}
	}

	private void sendMessage(final Article article) {
		jmsTemplate.convertAndSend(destination, article);
		log.debug("Article 메시지 전송함:"+article.getSubject());
	}

}
