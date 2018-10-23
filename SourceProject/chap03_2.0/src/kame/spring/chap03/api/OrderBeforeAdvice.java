package kame.spring.chap03.api;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class OrderBeforeAdvice implements MethodBeforeAdvice {
	private Log log = LogFactory.getLog(getClass());

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void before(Method method, Object[] arg, Object target)
			throws Throwable {
		log.info("call OrderBeforeAdvice: "+ name);
	}

}
