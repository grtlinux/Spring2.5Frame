package kame.spring.appc.service;

import java.util.List;

import kame.spring.appc.dao.CommentDao;
import kame.spring.appc.model.Comment;

public class ListCommentServiceImpl implements ListCommentService {

	private CommentDao commentDao;

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getComments() {
		return commentDao.selectAll();
	}

}
