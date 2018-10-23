package kame.spring.guestbook.service.junt4;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import kame.spring.guestbook.service.GuestBookListService;
import kame.spring.guestbook.service.ListResult;
import kame.spring.guestbook.service.Message;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:dataSource.xml",
		"classpath:service.xml", "classpath:dao-ibatis.xml" })
public class GuestBookListServiceAnnotTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private GuestBookListService guestBookListService;

	private String[][] testData = { { "�ֹ���", "�ȳ��ϼ���. ���õ� ���� �Ϸ�" },
			{ "madvirus", "�ȳ��ϼ���, ��ڴ�" }, { "javacan", "����Ʈ �� ���� ���ϴ�." },
			{ "����", "å ���ð� ������ �����ּ���" }, };

	@Test
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
		for (int i = 0; i < messages.size(); i++) {
			Message message = messages.get(i);
			assertEquals(testData[rowCount - i - 1][0], message.getGuestName());
			assertEquals(testData[rowCount - i - 1][1], message.getContent());
		}
	}

	private void insertData(String guestName, String content) {
		simpleJdbcTemplate
				.update(
						"insert into GUESTBOOK_MESSAGE (GUEST_NAME, CONTENT) values (?, ?)",
						guestName, content);
	}

}
