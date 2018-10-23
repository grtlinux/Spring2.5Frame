package kame.spring.chap02;

import org.springframework.beans.factory.annotation.Required;

public class SystemMonitor {

	private int periodTime;
	
	private MessageSender sender;

	public SystemMonitor(int period) {
		this(period, null);
	}

	public SystemMonitor(int period, MessageSender sender) {
		this.periodTime = period;
		this.sender = sender;
	}

	public SystemMonitor() {
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

	@Required
	public void setSender(MessageSender sender) {
		this.sender = sender;
	}
	
}
