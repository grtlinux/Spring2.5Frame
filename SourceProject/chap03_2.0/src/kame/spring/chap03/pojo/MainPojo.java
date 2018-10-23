package kame.spring.chap03.pojo;

import kame.spring.chap03.core.Article;
import kame.spring.chap03.core.ReadArticleService;
import kame.spring.chap03.core.WriteArticleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPojo {

	public static void main(String[] args) {
		String[] configs = { "kame/spring/chap03/pojo/contextPojo.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		WriteArticleService service = (WriteArticleService) context
				.getBean("writeArticleService");
		Integer articleId = service.write(new Article());

		ReadArticleService readArticleService = (ReadArticleService) context
				.getBean("readArticleService");
		Article article1 = readArticleService.readArticle(articleId);
		Article article2 = readArticleService.readArticle(articleId);
		System.out.println("article1 == article2:" + (article1 == article2));
	}
}
