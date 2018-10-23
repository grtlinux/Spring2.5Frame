package kame.spring.chap05.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class PageReportController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/bbs/telzone/list"));
		pageRanks.add(new PageRank(2, "/bbs/humor/list"));
		pageRanks.add(new PageRank(3, "/bbs/agora/list"));
		return new ModelAndView("pageReport", "pageRanks", pageRanks);
	}

}
