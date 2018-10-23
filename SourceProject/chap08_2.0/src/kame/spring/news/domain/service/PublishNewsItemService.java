package kame.spring.news.domain.service;

import kame.spring.news.domain.model.NewsItem;

public interface PublishNewsItemService {

	public void publish(NewsItem newsItem);
}
