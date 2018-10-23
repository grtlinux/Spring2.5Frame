package kame.spring.guestbook.service.junt4;

import static junit.framework.Assert.assertTrue;
import kame.spring.guestbook.service.GuestBookWriteService;
import kame.spring.guestbook.service.Message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dataSource.xml",
		"classpath:service.xml", "classpath:dao-ibatis.xml" })
public class GuestBookWriteServiceAnnotTest implements ApplicationContextAware {

	@Autowired
	private GuestBookWriteService guestBookWriteService;

	@Test
	public void testWrite() {
		Message message = new Message();
		message.setGuestName("¼Õ´Ô");
		message.setContent("³»¿ë");
		guestBookWriteService.write(message);

		assertTrue(message.getId() != 0);
		
		applicationContext.getBeanDefinitionCount();
	}
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
