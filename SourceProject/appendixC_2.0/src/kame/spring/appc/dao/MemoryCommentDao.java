package kame.spring.appc.dao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import kame.spring.appc.model.Comment;

public class MemoryCommentDao implements CommentDao {

	private int nextId = 1;

	private List<Comment> comments = new LinkedList<Comment>();

	public MemoryCommentDao() {
		Comment initValue = new Comment();
		initValue.setContent("ÄÁÅÙÃ÷");
		initValue.setWriterName("ÀÛ¼ºÀÚ");
		insert(initValue);
	}
	
	@Override
	public void insert(Comment comment) {
		comment.setId(nextId++);
		comments.add(comment);
	}

	@Override
	public List<Comment> selectAll() {
		return Collections.unmodifiableList(comments);
	}

}
