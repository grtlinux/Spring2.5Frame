package kame.spring.bbs.domain.service;

import kame.spring.bbs.domain.model.Article;

import org.springframework.context.ApplicationEvent;

public class ArticleCreationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private Article article;

	public ArticleCreationEvent(Object source, Article article) {
		super(source);
		this.article = article;
	}

	public Article getArticle() {
		return article;
	}

}
