package kame.spring.search.bbs;

import kame.spring.bbs.domain.model.Article;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArticlePojoListener {

	private Log log = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public void received(Article article) {
		log.debug("�޽��� ���޹���");
		processReceiveArtice(article);
	}

	private void processReceiveArtice(Article article) {
		log.debug("Article ���� ó�� ��û:" + article.getSubject());
	}

}
