package kame.spring.chap04.controller.annot;

import javax.annotation.Resource;

import kame.spring.chap04.controller.SearchCommand;
import kame.spring.chap04.controller.SearchResult;
import kame.spring.chap04.controller.SearchService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchAnnotController {

	@Resource(name = "internalSearchService")
	private SearchService internalSearchService;

	@Resource(name = "externalSearchService")
	private SearchService externalSearchService;

	public void setInternalSearchService(SearchService internalSearchService) {
		this.internalSearchService = internalSearchService;
	}

	public void setExternalSearchService(SearchService externalSearchService) {
		this.externalSearchService = externalSearchService;
	}

	@RequestMapping("/annot/search/internal.do")
	public String searchInternal(@RequestParam("query")
	String query, @RequestParam("pageNo")
	int pageNo, ModelMap modelMap) {
		return search(internalSearchService, query, pageNo, modelMap);
	}

	@RequestMapping("/annot/search/external.do")
	public String searchExternal(SearchCommand command, ModelMap modelMap) {
		return search(externalSearchService, command.getQuery(), command
				.getPageNo(), modelMap);
	}

	private String search(SearchService searchService, String query,
			int pageNo, ModelMap modelMap) {
		SearchResult result = searchService.search(query, pageNo);
		modelMap.addAttribute("result", result);
		return "searchResult";
	}
}
