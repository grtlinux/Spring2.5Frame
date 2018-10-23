package kame.spring.guestbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kame.spring.guestbook.service.GuestBookListService;
import kame.spring.guestbook.service.ListResult;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ListController extends AbstractController {

	private GuestBookListService guestBookListService;
	
	public void setGuestBookListService(GuestBookListService guestBookListService) {
		this.guestBookListService = guestBookListService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pageParam = request.getParameter("page");
		int page = 1;
		if (pageParam != null)
			page = Integer.parseInt(pageParam);
		
		ListResult listResult = guestBookListService.getMessages(page, 10);
		return new ModelAndView("list", "listResult", listResult);
	}

}
