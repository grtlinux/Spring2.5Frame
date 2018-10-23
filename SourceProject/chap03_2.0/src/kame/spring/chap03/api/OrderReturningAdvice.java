package kame.spring.chap03.api;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class OrderReturningAdvice implements AfterReturningAdvice {

	private Log log = LogFactory.getLog(getClass());

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		log.info("call OrderReturningAdvice: "+ name);
	}

}
