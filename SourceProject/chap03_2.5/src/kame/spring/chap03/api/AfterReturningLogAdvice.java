package kame.spring.chap03.api;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class AfterReturningLogAdvice implements AfterReturningAdvice {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		if (log.isTraceEnabled()) {
			log.trace(method.getName() + " on " + target
					+ " called\nreturn value is " + returnValue);
		}
	}
}
