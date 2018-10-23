package kame.spring.chap08;

import kame.spring.bbs.domain.model.Member;
import kame.spring.bbs.domain.service.RegistrationService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForMail {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForMail.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		RegistrationService registrationService = (RegistrationService) context
				.getBean("registrationService");
		Member member = new Member();
		member.setName("ÃÖ¹ü±Õ");
		member.setEmail("madvirus2@gmail.com");
		registrationService.regist(member);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.close();
	}
}
