package kame.spring.guestbook.service;

import java.util.List;

public class ListResult {

	private int page;
	private int totalCount;
	private int pageSize;
	private List<Message> messages;
	private int totalPageCount;

	public ListResult(int page, int totalCount, int pageSize,
			List<Message> messages) {
		this.page = page;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.messages = messages;
		this.totalPageCount = calculateTotalPageCount();
	}

	private int calculateTotalPageCount() {
		int pageCount = totalCount / pageSize;
		if (totalCount > 0 && totalCount % pageSize == 0)
			pageCount++;
		return pageCount;
	}

	public int getPage() {
		return page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

}
