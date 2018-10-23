package kame.spring.chap03.pojo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

	private Log log = LogFactory.getLog(getClass());

	public String beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("calling: " + methodName);
		return methodName;
	}

	public void returningLogging(JoinPoint joinPoint, Object ret) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("called successfully: " + methodName + " returns " + ret);
	}

	public void throwingLogging(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("exception occured: " + methodName + " throws "
					+ ex.getClass().getName());
	}

	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("finish call: " + methodName);
	}
}
