package kame.spring.chap04.controller;

public class SearchResult {

	private String type;
	private String query;
	private int pageNo;

	public SearchResult(String type, String query, int pageNo) {
		this.type = type;
		this.query = query;
		this.pageNo = pageNo;
	}

	public String getType() {
		return type;
	}

	public String getQuery() {
		return query;
	}

	public int getPageNo() {
		return pageNo;
	}
}
