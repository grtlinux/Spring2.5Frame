package kame.spring.chap04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SearchController extends MultiActionController implements BeanNameAware {
	private Log log = LogFactory.getLog(getClass());
	
	private SearchService internalSearchService;
	private SearchService externalSearchService;
	
	private String beanName;

	public void setInternalSearchService(SearchService internalSearchService) {
		this.internalSearchService = internalSearchService;
	}

	public void setExternalSearchService(SearchService externalSearchService) {
		this.externalSearchService = externalSearchService;
	}

	public ModelAndView internal(HttpServletRequest request,
			HttpServletResponse response) {
		if (log.isDebugEnabled())
			log.debug(beanName + ".internal called");
		
		String query = request.getParameter("query");
		String page = request.getParameter("page");
		int pageNo = 1;
		if (page != null && page.length() > 0) {
			try {
				pageNo = Integer.parseInt(page);
			} catch (Exception ex) {
			}
		}
		return searh(internalSearchService, query, pageNo);
	}

	public ModelAndView external(HttpServletRequest request,
			HttpServletResponse response, SearchCommand command) {
		if (log.isDebugEnabled())
			log.debug(beanName + ".external called");
		
		return searh(externalSearchService, command.getQuery(), command
				.getPageNo());
	}

	private ModelAndView searh(SearchService searchService, String query,
			int pageNo) {
		SearchResult result = searchService.search(query, pageNo);
		return new ModelAndView("searchResult", "result", result);
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
}
