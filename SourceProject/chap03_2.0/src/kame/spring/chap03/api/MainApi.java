package kame.spring.chap03.api;

import java.util.List;

import kame.spring.chap03.core.Article;
import kame.spring.chap03.core.Board;
import kame.spring.chap03.core.GetBoardService;
import kame.spring.chap03.core.ReadArticleService;
import kame.spring.chap03.core.SearchService;
import kame.spring.chap03.core.WriteArticleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApi {

	public static void main(String[] args) {
		String[] configs = { "kame/spring/chap03/api/contextApi.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		WriteArticleService service = (WriteArticleService) context
				.getBean("writeArticleService");
		service.write(new Article());

		ReadArticleService readArticleService = (ReadArticleService) context
				.getBean("readArticleService");
		Article article = readArticleService.readArticle(new Integer(1));
		System.out.println(article);

		GetBoardService getBoardService = (GetBoardService) context
				.getBean("getBoardService");
		Board board = getBoardService.getBoard(new Integer(1));
		System.out.println(board.getId());

		SearchService searchService = (SearchService) context
				.getBean("searchService");
		String query = "boy";
		List<String> results = searchService.search(query);
		System.out.println(query + " search results:" + results.size());

	}
}
