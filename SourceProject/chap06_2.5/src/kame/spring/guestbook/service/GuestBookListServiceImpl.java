package kame.spring.guestbook.service;

import java.util.List;

import kame.spring.guestbook.dao.MessageDao;

public class GuestBookListServiceImpl implements GuestBookListService {

	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public ListResult getMessages(int page, int pageSize) {
		int totalCount = messageDao.selectCount();
		List<Message> messages = messageDao.selectList(page, pageSize);
		return new ListResult(page, totalCount, pageSize, messages);
	}

}
