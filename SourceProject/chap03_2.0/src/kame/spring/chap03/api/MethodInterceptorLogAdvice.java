package kame.spring.chap03.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MethodInterceptorLogAdvice implements MethodInterceptor {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (log.isTraceEnabled())
			log.trace(invocation.getMethod().getName() + " calling");

		try {
			Object returnValue = invocation.proceed();

			if (log.isTraceEnabled())
				log.trace(invocation.getMethod().getName()
						+ " called\nreturn value is " + returnValue);

			return returnValue;
		} catch (Throwable e) {
			if (log.isErrorEnabled())
				log.error("error occured while processing "
						+ invocation.getMethod().getName());

			throw e;
		} finally {
			if (log.isTraceEnabled())
				log.trace(invocation.getMethod().getName()
						+ " processing completed");
		}
	}

}
