package kame.spring.chap03.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CacheInterceptor implements MethodInterceptor {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (log.isTraceEnabled())
			log.trace("Cache Processing for "
					+ invocation.getMethod().getName());

		Object retVal = invocation.proceed();
		return retVal;
	}

}
