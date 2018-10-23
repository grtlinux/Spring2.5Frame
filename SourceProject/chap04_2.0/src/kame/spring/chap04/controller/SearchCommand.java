package kame.spring.chap04.controller;

public class SearchCommand {

	private String query;
	private String page;

	public String getQuery() {
		return query;
	}

	public void setQuery(String q) {
		this.query = q;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String p) {
		this.page = p;
	}

	public int getPageNo() {
		if (page != null && page.length() > 0) {
			try {
				return Integer.parseInt(page);
			} catch (Exception ex) {
			}
		}
		return 1;
	}

}
