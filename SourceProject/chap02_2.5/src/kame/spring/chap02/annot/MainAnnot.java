package kame.spring.chap02.annot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnot {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextAnnot.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);

		SystemMonitor monitor = (SystemMonitor) context.getBean("monitor");
		MessageSender sender = (MessageSender) context.getBean("smsSender");
		Sensor sensor = (Sensor) context.getBean("sensor1");
		if (monitor.getSensors() != null)
			System.out.println(monitor.getSensors().length);
		else
			System.out.println("sensors is null");
		System.out.println(monitor.getSender() == sender);
		System.out.println(monitor.getSensor() == sensor);
		
		System.out.println(monitor.getMainCamera() == context.getBean("lobbyCamera"));
		
		((AbstractApplicationContext)context).destroy();
		
	}
}
