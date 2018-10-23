package kame.spring.appc.service;

import kame.spring.appc.dao.CommentDao;
import kame.spring.appc.model.Comment;

public class WriteCommentServiceImpl implements WriteCommentService {

	private CommentDao commentDao;

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public Comment write(Comment comment) {
		commentDao.insert(comment);
		return comment;
	}

}
