package kame.spring.chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForEvent {

	public static void main(String[] args) {
		String[] configLocations = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);

		Object source = new Object();
		context.publishEvent(new CustomEvent(source));
	}
}
