package kame.spring.chap08;

import kame.spring.bbs.domain.model.Article;
import kame.spring.search.bbs.ArticleReceiver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForArticleJmsReceiver {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForArticleJmsReceiver.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		ArticleReceiver articleReceiver = (ArticleReceiver) context
				.getBean("articleReceiver");
		while (true) {
			Article article = articleReceiver.receive();
			System.out.println("Article ¹ÞÀ½:" + article.getSubject());
		}
	}

}
