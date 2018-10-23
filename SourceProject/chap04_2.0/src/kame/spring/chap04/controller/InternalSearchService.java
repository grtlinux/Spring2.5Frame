package kame.spring.chap04.controller;

public class InternalSearchService implements SearchService {

	@Override
	public SearchResult search(String query, int page) {
		return new SearchResult("내부검색", query, page);
	}

}
