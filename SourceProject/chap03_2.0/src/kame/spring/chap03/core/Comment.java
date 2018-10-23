package kame.spring.chap03.core;

public class Comment {

	private Integer id;
	private Integer articleId;
	private String content;

	public Comment(Integer id, Integer articleId, String content) {
		this.id = id;
		this.articleId = articleId;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
