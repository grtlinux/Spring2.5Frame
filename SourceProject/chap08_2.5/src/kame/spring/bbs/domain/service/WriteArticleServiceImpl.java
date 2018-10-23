package kame.spring.bbs.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import kame.spring.bbs.domain.model.Article;

public class WriteArticleServiceImpl implements WriteArticleService,
		ApplicationContextAware {

	private Log log = LogFactory.getLog(getClass());

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}

	@Override
	public void write(Article article) {
		log.debug("货肺款 Article 积己");
		context.publishEvent(new ArticleCreationEvent(this, article));
	}

}
