package kame.spring.express;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class CompleteDeliveryServiceImpl implements CompleteDeliveryService {

	private Log log = LogFactory.getLog(getClass());

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public void complete(final String invoiceNo) {
		// JMS 메시지 전송
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(invoiceNo);
				return textMessage;
			}
		});
		log.debug("배송 완료 메시지 전송:" + invoiceNo);
		
		// complete 메서드가 트랜잭션 범위 내에서 실행될 경우,
		// 트랜잭션이 커밋된 이후에 비로서 메시지가 완전히 전송된다.
	}

}
