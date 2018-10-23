package kame.spring.bbs.domain.model;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String title) {
		this.subject = title;
	}

}
