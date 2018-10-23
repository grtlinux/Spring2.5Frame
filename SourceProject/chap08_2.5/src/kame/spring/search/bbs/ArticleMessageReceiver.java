package kame.spring.search.bbs;

import kame.spring.bbs.domain.model.Article;

import org.springframework.jms.core.support.JmsGatewaySupport;

public class ArticleMessageReceiver extends JmsGatewaySupport implements
		ArticleReceiver {

	public Article receive() {
		Article article = (Article) getJmsTemplate().receiveAndConvert();
		return article;
	}
}
