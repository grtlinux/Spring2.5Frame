package kame.spring.chap03.annot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotLoggingAspect {
	private Log log = LogFactory.getLog(getClass());

	@Before("execution(public * kame.spring.chap03.core.*.*(..))")
	public String beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("calling: " + methodName);
		return methodName;
	}

	@AfterReturning(pointcut = "execution(public * kame.spring.chap03.core.*.*(..))", returning = "ret")
	public void returningLogging(JoinPoint joinPoint, Object ret) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("called successfully: " + methodName + " returns " + ret);
	}

	@AfterThrowing(pointcut = "execution(public * kame.spring.chap03.core.*.*(..))", throwing = "ex")
	public void throwingLogging(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("exception occured: " + methodName + " throws "
					+ ex.getClass().getName());
	}

	@After("execution(public * kame.spring.chap03.core.*.*(..))")
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if (log.isTraceEnabled())
			log.trace("finish call: " + methodName);
	}
}
