package kame.spring.chap08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForArticleMessageListener {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForArticleMessageListener.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.close();
	}

}
