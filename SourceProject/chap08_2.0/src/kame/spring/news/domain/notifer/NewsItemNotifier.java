package kame.spring.news.domain.notifer;

import kame.spring.news.domain.model.NewsItem;

public interface NewsItemNotifier {
	public void notify(NewsItem newsItem);
}
