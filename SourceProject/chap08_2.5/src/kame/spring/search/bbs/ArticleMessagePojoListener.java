package kame.spring.search.bbs;

import java.util.Map;

import kame.spring.bbs.domain.model.Article;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArticleMessagePojoListener {

	private Log log = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public void received(Map map) {
		log.debug("메시지 전달받음");
		Article article = new Article();
		article.setSubject((String) map.get("subject"));
		processReceiveArtice(article);
	}

	private void processReceiveArtice(Article article) {
		log.debug("Article 색인 처리 요청:" + article.getSubject());
	}

}
