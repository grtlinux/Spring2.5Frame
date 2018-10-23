package kame.spring.chap02;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] configLocations = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		SystemMonitor monitor = (SystemMonitor) context.getBean("monitor");
		System.out.println("monitor.period: " + monitor.getPeriodTime());
		
		Locale locale = Locale.getDefault();
		Locale enLocale = Locale.ENGLISH;
		
		System.out.println(context.getMessage("greeting", new Object[0], locale));
		System.out.println(context.getMessage("greeting", new Object[0], enLocale));
		
		System.out.println(context.getMessage("ERR001", new Object[0], locale));
	}
}
