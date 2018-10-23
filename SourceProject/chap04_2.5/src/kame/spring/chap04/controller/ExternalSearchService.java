package kame.spring.chap04.controller;

public class ExternalSearchService implements SearchService {

	@Override
	public SearchResult search(String query, int page) {
		return new SearchResult("외부검색", query, page);
	}

}
