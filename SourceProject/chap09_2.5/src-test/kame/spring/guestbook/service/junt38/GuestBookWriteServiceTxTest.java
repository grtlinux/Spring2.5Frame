package kame.spring.guestbook.service.junt38;

import kame.spring.guestbook.service.GuestBookWriteService;
import kame.spring.guestbook.service.Message;

import org.springframework.test.AbstractTransactionalSpringContextTests;

public class GuestBookWriteServiceTxTest extends
		AbstractTransactionalSpringContextTests {

	private GuestBookWriteService guestBookWriteService;

	public GuestBookWriteServiceTxTest() {
		// setDefaultRollback(false);
	}

	public void setGuestBookWriteService(
			GuestBookWriteService guestBookWriteService) {
		this.guestBookWriteService = guestBookWriteService;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] {
				"classpath:dataSource.xml",
				"classpath:service.xml",
				"classpath:dao-ibatis.xml"
		};
	}
	
	public void testWrite() {
		Message message = new Message();
		message.setGuestName("¼Õ´Ô");
		message.setContent("³»¿ë");
		guestBookWriteService.write(message);
		
		assertTrue(message.getId() != 0);
		
		// setComplete();
	}
	
}
