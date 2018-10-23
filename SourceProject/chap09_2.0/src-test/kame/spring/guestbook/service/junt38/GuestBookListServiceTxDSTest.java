package kame.spring.guestbook.service.junt38;

import java.util.List;

import kame.spring.guestbook.service.GuestBookListService;
import kame.spring.guestbook.service.ListResult;
import kame.spring.guestbook.service.Message;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class GuestBookListServiceTxDSTest extends
		AbstractTransactionalDataSourceSpringContextTests {

	private GuestBookListService guestBookListService;

	public void setGuestBookListService(
			GuestBookListService guestBookListService) {
		this.guestBookListService = guestBookListService;
	}

	@Override 
	protected String[] getConfigLocations() {
		return new String[] { "classpath:dataSource.xml",
				"classpath:service.xml", "classpath:dao-ibatis.xml" };
	}

	private String[][] testData = {
			{"최범균", "안녕하세요. 오늘도 좋은 하루"},
			{"madvirus", "안녕하세요, 운영자님"},
			{"javacan", "사이트 잘 보고 갑니다."},
			{"가메", "책 쓰시고 싶으면 연락주세요"},
	};
	
	public void testList() {
		for (String[] row : testData) {
			insertData(row[0], row[1]);
		}
		ListResult listResult = guestBookListService.getMessages(1, 3);
		assertEquals(1, listResult.getPage());
		assertEquals(3, listResult.getPageSize());
		assertEquals(3, listResult.getMessages().size());
		
		List<Message> messages = listResult.getMessages();
		int rowCount = testData.length;
		for (int i = 0 ; i < messages.size() ; i++) {
			Message message = messages.get(i);
			assertEquals(testData[rowCount-i-1][0], message.getGuestName());
			assertEquals(testData[rowCount-i-1][1], message.getContent());
		}
	}

	private void insertData(String guestName, String content) {
		jdbcTemplate
				.update(
						"insert into GUESTBOOK_MESSAGE (GUEST_NAME, CONTENT) values (?, ?)",
						new Object[] { guestName, content });
	}
}
