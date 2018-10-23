package kame.spring.guestbook.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class GuestBookWriteServiceTest extends TestCase {

	private ApplicationContext context;
	private GuestBookWriteService writeService;

	@Override
	protected void setUp() throws Exception {
		String[] configLocations = { "dataSource.xml", "service.xml",
				"dao-ibatis.xml" };
		context = new ClassPathXmlApplicationContext(configLocations);
		writeService = (GuestBookWriteService) context
				.getBean("guestBookWriteService");
	}

	public void testWrite() {
		Message message = new Message();
		message.setGuestName("¼Õ´Ô");
		message.setContent("³»¿ë");
		writeService.write(message);
		
		assertTrue(message.getId() != 0);
	}

}
