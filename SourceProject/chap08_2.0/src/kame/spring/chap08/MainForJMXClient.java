package kame.spring.chap08;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import kame.spring.monitor.PerformanceMonitorRemoteMBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForJMXClient {

	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForJMXClient.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);

		MBeanServerConnection connection = (MBeanServerConnection) context
				.getBean("mbeanServerlClient");

		ObjectName mbeanName = null;
		try {
			mbeanName = new ObjectName("kame:name=monitor");
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
			return;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return;
		}

		try {
			printViewCount(connection, mbeanName);
		} catch (Throwable e1) {
			return;
		}

		try {
			invokeIncreaseViewCount(connection, mbeanName);
		} catch (Throwable e) {
			return;
		}

		try {
			printViewCount(connection, mbeanName);
		} catch (Throwable e1) {
			return;
		}
		
		PerformanceMonitorRemoteMBean performanceMonitor = (PerformanceMonitorRemoteMBean) context
				.getBean("performanceMonitor");
		performanceMonitor.increaseViewCount(3000);
		System.out.println("PerformanceMonitor.increaseViewCount() 호출");
		System.out.println("PerformanceMonitor.getViewCount():"
				+ performanceMonitor.getViewCount());
	}

	private static void invokeIncreaseViewCount(
			MBeanServerConnection connection, ObjectName mbeanName)
			throws Throwable {
		try {
			connection.invoke(mbeanName, "increaseViewCount",
					new Object[] { 300L }, new String[] { "long" });
			System.out.println("increaseViewCount 호출");
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (MBeanException e) {
			e.printStackTrace();
			throw e;
		} catch (ReflectionException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static void printViewCount(MBeanServerConnection connection,
			ObjectName mbeanName) throws Throwable {
		try {
			Object attribute = connection.getAttribute(mbeanName, "ViewCount");
			System.out.println("ViewCount = " + attribute + ", type:"
					+ attribute.getClass());
		} catch (AttributeNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (MBeanException e) {
			e.printStackTrace();
			throw e;
		} catch (ReflectionException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
