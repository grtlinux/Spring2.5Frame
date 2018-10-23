package kame.spring.chap08;

import kame.spring.news.domain.model.NewsItem;
import kame.spring.news.domain.service.PublishNewsItemService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForNewsItemPublish {
	private static Log log = LogFactory.getLog(MainForNewsItemPublish.class);

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
			log.debug("뉴스 아이템 출판 완료");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.debug("컨텍스트 종료 시작");
		context.close();
		log.debug("컨텍스트 종료 완료");
	}
}
