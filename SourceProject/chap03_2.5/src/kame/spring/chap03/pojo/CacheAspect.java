package kame.spring.chap03.pojo;

import java.util.HashMap;
import java.util.Map;

import kame.spring.chap03.core.Article;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	private Log log = LogFactory.getLog(getClass());

	private Map<Integer, Article> cache = new HashMap<Integer, Article>();

	public Article read(ProceedingJoinPoint joinPoint) throws Throwable {
		Integer id = (Integer) joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if (article != null) {
			if (log.isTraceEnabled())
				log.trace("get article[" + id + "] from cache");
			return article;
		}
		try {
			Object ret = joinPoint.proceed();
			if (log.isTraceEnabled())
				log.trace("proceeding target method: "
						+ joinPoint.getSignature().getName());
			if (ret != null) {
				if (log.isTraceEnabled())
					log.trace("put article[" + id + "] into cache");
				cache.put(id, (Article) ret);
			}
			return (Article) ret;
		} catch (Throwable e) {
			throw e;
		}
	}
}
