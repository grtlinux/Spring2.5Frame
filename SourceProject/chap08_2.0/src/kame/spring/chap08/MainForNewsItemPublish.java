package kame.spring.chap08;

import kame.spring.news.domain.model.NewsItem;
import kame.spring.news.domain.service.PublishNewsItemService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForNewsItemPublish {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForNewsItemPublish.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		PublishNewsItemService publishNewsItemService = (PublishNewsItemService) context
				.getBean("publishNewsItemService");
		NewsItem newsItem = new NewsItem();
		newsItem.setSubject("뉴스 제목:"
				+ Long.toString(System.currentTimeMillis()));
		try {
			publishNewsItemService.publish(newsItem);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		context.close();
	}
}
