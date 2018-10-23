package kame.spring.chap03.annot;

import java.util.HashMap;
import java.util.Map;

import kame.spring.chap03.core.Article;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AnnotCacheAspect {
	private Log log = LogFactory.getLog(getClass());

	private Map<Integer, Article> cache = new HashMap<Integer, Article>();

	@Around("execution(public * kame.spring.chap03.core.*.readArticle(..))")
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
