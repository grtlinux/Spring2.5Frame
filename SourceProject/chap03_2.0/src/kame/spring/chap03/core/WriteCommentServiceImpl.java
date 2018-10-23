package kame.spring.chap03.core;

public class WriteCommentServiceImpl implements WriteCommentService {

	private int nextId;
	
	@Override
	public Comment writeComment(Integer articleId, String content) {
		return new Comment(nextId++, articleId, content);
	}

}
