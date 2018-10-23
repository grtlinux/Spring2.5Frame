package kame.spring.appc.dao;

import java.util.List;

import kame.spring.appc.model.Comment;

public interface CommentDao {

	public void insert(Comment comment);
	public List<Comment> selectAll();

}
