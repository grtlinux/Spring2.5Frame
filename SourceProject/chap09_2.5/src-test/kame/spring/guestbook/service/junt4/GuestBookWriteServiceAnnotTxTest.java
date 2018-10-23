package kame.spring.guestbook.service.junt4;

import static junit.framework.Assert.assertTrue;
import kame.spring.guestbook.service.GuestBookWriteService;
import kame.spring.guestbook.service.Message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dataSource.xml",
		"classpath:service.xml", "classpath:dao-ibatis.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class GuestBookWriteServiceAnnotTxTest {

	@Autowired(required = true)
	private GuestBookWriteService guestBookWriteService;

	@Test
	@Rollback(true)
	public void testWrite() {
		Message message = new Message();
		message.setGuestName("¼Õ´Ô");
		message.setContent("³»¿ë");
		guestBookWriteService.write(message);

		assertTrue(message.getId() != 0);
	}
	
	@Test
	@NotTransactional
	public void testNoNeedTransaction() {
		
	}
}
