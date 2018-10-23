package kame.spring.chap03.api;

import kame.spring.chap03.core.Article;
import kame.spring.chap03.core.WriteArticleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApiAdviceOrder {

	public static void main(String[] args) {
		String[] configs = { "kame/spring/chap03/api/contextApiAdviceOrder.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		WriteArticleService service = (WriteArticleService) context
				.getBean("writeArticleService");
		service.write(new Article());
	}
}
