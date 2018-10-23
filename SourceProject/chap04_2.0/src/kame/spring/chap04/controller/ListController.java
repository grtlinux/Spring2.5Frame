package kame.spring.chap04.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class ListController extends AbstractCommandController {

	private ListService listService;

	public void setListService(ListService listService) {
		this.listService = listService;
	}

	public ListController() {
		setCommandClass(ListCommand.class);
//		setCommandName("listCommand");
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ListCommand listCommand = (ListCommand) command;
		List<Article> articleList = listService.getList(listCommand.getBbsId(),
				listCommand.getPageNo(), listCommand.getSearchKeyword());
		return new ModelAndView("list", "articleList", articleList);
	}

}
