package kame.spring.chap08;

import java.util.Random;

import kame.spring.monitor.PerformanceMonitor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForJMX {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForJMX.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		PerformanceMonitor monitor = (PerformanceMonitor) context
				.getBean("monitor");

		Random rand = new Random();
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(rand.nextInt(500) + 500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			monitor.increaseViewCount(rand.nextInt(1000) + 500);
		}
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.close();
	}
}
