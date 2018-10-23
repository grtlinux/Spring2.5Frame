package kame.spring.chap08;

import kame.spring.bbs.domain.model.Article;
import kame.spring.bbs.domain.service.WriteArticleService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForArticleJmsSender {
	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForArticleJmsSender.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		WriteArticleService writeArticleService = (WriteArticleService) context
				.getBean("writeArticleService");
		Article article = new Article();
		article.setSubject("±Û Á¦¸ñ:" + Long.toString(System.currentTimeMillis()));
		writeArticleService.write(article);
	}
}
