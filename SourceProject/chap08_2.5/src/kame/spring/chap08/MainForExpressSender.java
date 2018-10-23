package kame.spring.chap08;

import kame.spring.express.CompleteDeliveryService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForExpressSender {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForExpSender.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		CompleteDeliveryService completeDeliveryService = (CompleteDeliveryService) context
				.getBean("completeDeliveryService");
		String invoceNo = Long.toString(System.currentTimeMillis());
		completeDeliveryService.complete(invoceNo);
		context.close();
	}
}
