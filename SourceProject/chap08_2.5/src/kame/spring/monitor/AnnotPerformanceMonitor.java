package kame.spring.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName="kame:name=AnnotMonitor", description="어노테이션 이용")
public class AnnotPerformanceMonitor {
	private Log log = LogFactory.getLog(getClass());

	private int viewCount;
	private long sumOfResponseTime;
	private double averageResponseTime;

	@ManagedAttribute
	public int getViewCount() {
		return viewCount;
	}
	@ManagedAttribute
	public void setViewCount(int pageView) {
		this.viewCount = pageView;
	}
	
	@ManagedAttribute
	public double getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(double averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	@ManagedOperation
	public void increaseViewCount(long responseTime) {
		viewCount++;
		sumOfResponseTime += responseTime;
		averageResponseTime = (double) sumOfResponseTime / (double) viewCount;
		log.debug("viewCount 1증가:responseTime=" + responseTime);
	}
	
	@ManagedOperation
	public void reset() {
		log.info("reset()");
		viewCount = 0;
		sumOfResponseTime = 0;
		averageResponseTime = 0.0;
	}
}
