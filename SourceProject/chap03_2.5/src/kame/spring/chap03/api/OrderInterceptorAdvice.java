package kame.spring.chap03.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderInterceptorAdvice implements MethodInterceptor {

	private Log log = LogFactory.getLog(getClass());

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("call OrderInterceptorAdvice before: "+ name);
		Object ret = invocation.proceed();
		log.info("call OrderInterceptorAdvice after: "+ name);
		return ret;
	}

}
