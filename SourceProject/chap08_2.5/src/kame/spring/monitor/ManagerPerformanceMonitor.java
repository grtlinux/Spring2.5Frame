package kame.spring.monitor;

public interface ManagerPerformanceMonitor {

	void increaseViewCount(long responseTime);
	
	public int getViewCount();
	public void setViewCount();
}
