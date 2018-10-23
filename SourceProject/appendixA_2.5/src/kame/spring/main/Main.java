package kame.spring.main;

import kame.spring.appA.PrintService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContext.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		PrintService printService = (PrintService) context
				.getBean("printService");
		printService.printToday();
		System.out.println("³¡!!!");
	}
}
