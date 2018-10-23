package kame.spring.bbs.domain.notification;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import kame.spring.bbs.domain.model.Member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class RegistrationNotifierWithAttachment extends
		AbstractRegistrationNotifier {

	private Log log = LogFactory.getLog(getClass());

	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	protected void sendEmailTo(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "euc-kr");
			messageHelper.setSubject("회원 가입 안내 [Attachemtn]");
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("madvirus@madvirus.net", "자바캔");
			messageHelper.setTo(new InternetAddress(member.getEmail(), member
					.getName(), "euc-kr"));

			DataSource dataSource = new FileDataSource("attachmentfile/회원가입안내문.doc");
			messageHelper.addAttachment(MimeUtility.encodeText("회원가입안내문.doc",
					"euc-kr", "B"), dataSource);
		} catch (MessagingException e) {
			log.warn("fail to MimeMessage", e);
			return;
		} catch (UnsupportedEncodingException e) {
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
