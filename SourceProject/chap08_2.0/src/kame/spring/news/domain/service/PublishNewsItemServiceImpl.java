package kame.spring.news.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kame.spring.news.domain.dao.NewsItemDao;
import kame.spring.news.domain.model.NewsItem;
import kame.spring.news.domain.notifer.NewsItemNotifier;

public class PublishNewsItemServiceImpl implements PublishNewsItemService {

	private Log log = LogFactory.getLog(getClass());

	private NewsItemDao newsItemDao;
	private NewsItemNotifier newsItemNotifier;

	public void setNewsItemDao(NewsItemDao newsItemDao) {
		this.newsItemDao = newsItemDao;
	}

	public void setNewsItemNotifier(NewsItemNotifier newsItemNotifier) {
		this.newsItemNotifier = newsItemNotifier;
	}

	@Override
	public void publish(NewsItem newsItem) {
		newsItemNotifier.notify(newsItem);
		log.debug("NewsItem 메시지 전송:" + newsItem.getSubject());
		newsItemDao.insert(newsItem);
		log.debug("NewsItem DB 삽입:" + newsItem.getSubject());
	}

}
