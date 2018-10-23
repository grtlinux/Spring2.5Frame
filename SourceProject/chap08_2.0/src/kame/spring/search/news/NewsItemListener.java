package kame.spring.search.news;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NewsItemListener {

	private Log log = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public void listen(Map newsItemMap) {
		log.debug("뉴스 정보 받음:" + newsItemMap.get("subject"));
	}
}
