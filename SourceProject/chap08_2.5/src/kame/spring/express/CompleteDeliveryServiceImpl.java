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
		// JMS �޽��� ����
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(invoiceNo);
				return textMessage;
			}
		});
		log.debug("��� �Ϸ� �޽��� ����:" + invoiceNo);
		
		// complete �޼��尡 Ʈ����� ���� ������ ����� ���,
		// Ʈ������� Ŀ�Ե� ���Ŀ� ��μ� �޽����� ������ ���۵ȴ�.
	}

}
