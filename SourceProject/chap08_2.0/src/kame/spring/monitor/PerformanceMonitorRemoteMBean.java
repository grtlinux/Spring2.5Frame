package kame.spring.monitor;

public interface PerformanceMonitorRemoteMBean {
	int getViewCount();
	long getSumOfResponseTime();
	public double getAverageResponseTime();

	public void increaseViewCount(long responseTime);
	public void reset();

}
