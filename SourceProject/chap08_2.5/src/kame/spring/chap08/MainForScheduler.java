package kame.spring.chap08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForScheduler {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForScheduler.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		context.close();
	}
}
