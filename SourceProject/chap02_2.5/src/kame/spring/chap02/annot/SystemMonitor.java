package kame.spring.chap02.annot;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SystemMonitor {

	private int periodTime;

	private MessageSender sender;

	private Sensor[] sensors;
	
	@Resource(name="sensor1")
	private Sensor sensor;
	
	@Autowired
	@Qualifier("main")
	private Camera mainCamera;

	public SystemMonitor(MessageSender sender) {
		this.sender = sender;
	}

	public SystemMonitor() {
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

	public int getPeriodTime() {
		return periodTime;
	}

	public void setPeriodTime(int period) {
		this.periodTime = period;
	}

	public MessageSender getSender() {
		return sender;
	}

	@Resource(name="smsSender")
	public void setSender(MessageSender sender) {
		this.sender = sender;
	}

	public Sensor getSensor() {
		return sensor;
	}
	public Sensor[] getSensors() {
		return sensors;
	}

	@Autowired
	public void setSensors(Sensor[] sensors) {
		this.sensors = sensors;
	}

	public Camera getMainCamera() {
		return mainCamera;
	}
	
}
