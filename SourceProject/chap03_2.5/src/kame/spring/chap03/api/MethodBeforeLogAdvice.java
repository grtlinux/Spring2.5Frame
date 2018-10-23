package kame.spring.chap03.api;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeLogAdvice implements MethodBeforeAdvice {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		if (log.isTraceEnabled())
			log.trace(method.getName() + " on " + target + " calling");
	}

}
