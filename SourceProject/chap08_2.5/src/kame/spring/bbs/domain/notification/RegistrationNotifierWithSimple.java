package kame.spring.bbs.domain.notification;

import kame.spring.bbs.domain.model.Member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class RegistrationNotifierWithSimple extends AbstractRegistrationNotifier {

	private Log log = LogFactory.getLog(getClass());
	
	private MailSender mailSender;
	private SimpleMailMessage templateMailMessage;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setTemplateMailMessage(SimpleMailMessage templateMailMessage) {
		this.templateMailMessage = templateMailMessage;
	}

	protected void sendEmailTo(Member member) {
		SimpleMailMessage message = new SimpleMailMessage(templateMailMessage);
		message.setText("ȸ�� ������ ȯ���մϴ�.");
		message.setTo(member.getEmail());
		try {
			mailSender.send(message);
			if (log.isDebugEnabled()) {
				log.debug("Sent mail successfully!");
			}
		} catch(MailException ex) {
			log.warn("fail to send mail:"+message, ex);
		}
	}

}
