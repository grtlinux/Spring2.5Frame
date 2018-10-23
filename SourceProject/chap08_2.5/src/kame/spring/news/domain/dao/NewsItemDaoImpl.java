package kame.spring.news.domain.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import kame.spring.news.domain.model.NewsItem;

public class NewsItemDaoImpl extends JdbcDaoSupport implements NewsItemDao {

	@Override
	public void insert(NewsItem newsItem) {
		getJdbcTemplate().update("insert into NEWS_ITEM (SUBJECT) values (?)",
				new Object[] { newsItem.getSubject() });
	}

}
