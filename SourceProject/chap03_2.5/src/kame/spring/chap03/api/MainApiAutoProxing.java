package kame.spring.chap03.api;

import kame.spring.chap03.core.Article;
import kame.spring.chap03.core.ReadArticleService;
import kame.spring.chap03.core.WriteArticleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApiAutoProxing {

	public static void main(String[] args) {
		String[] configs = { "kame/spring/chap03/api/contextApiAutoProxing.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		WriteArticleService service = (WriteArticleService) context
				.getBean("writeArticleService");
		service.write(new Article());

		ReadArticleService readArticleService = (ReadArticleService) context
				.getBean("readArticleService");
		Article article = readArticleService.readArticle(new Integer(1));
		System.out.println(article);
	}
}
