package kame.spring.bbs.domain.notification;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import kame.spring.bbs.domain.model.Member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

public class RegistrationNotifierWithMime extends AbstractRegistrationNotifier {

	private Log log = LogFactory.getLog(getClass());

	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	protected void sendEmailTo(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setSubject("ȸ�� ���� �ȳ� [Mime]", "euc-kr");
			String htmlContent = "<strong>�ȳ��ϼ���</strong>, �ݰ����ϴ�.";
			message.setContent(htmlContent, "text/html; charset=euc-kr");
			// message.setText(htmlContent, "euc-kr", "html"); // Mail API 1.4
			message.setFrom(new InternetAddress("madvirus@madvirus.net"));
			message.addRecipient(RecipientType.TO, new InternetAddress(member
					.getEmail()));
		} catch (MessagingException e) {
			log.warn("fail to MimeMessage", e);
			return;
		}
		try {
			mailSender.send(message);
			if (log.isDebugEnabled()) {
				log.debug("Sent mail successfully!");
			}
		} catch (MailException e) {
			log.warn("fail to send MimeMessage:" + e.getMessage(), e);
		}
	}

}
