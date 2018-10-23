package kame.spring.guestbook.dao;

import java.util.List;

import kame.spring.guestbook.service.Message;

public interface MessageDao {

	int selectCount();

	List<Message> selectList(int page, int pageSize);

	void insert(Message message);

}
