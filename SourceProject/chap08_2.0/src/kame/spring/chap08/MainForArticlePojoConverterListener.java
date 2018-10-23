package kame.spring.chap08;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainForArticlePojoConverterListener {
	private static Log log = LogFactory.getLog(MainForArticlePojoConverterListener.class);
	
	public static void main(String[] args) {
		String[] configLocations = { "applicationContextForArticlePojoConverterListener.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		log.debug("Context Ω√¿€µ ");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.close();
		log.debug("Context ¡æ∑·");
	}
}
