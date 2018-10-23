package kame.spring.chap04.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListServiceImpl implements ListService {

	private Log log = LogFactory.getLog(getClass());

	@Override
	public List<Article> getList(String bbsId, Integer pageNo,
			String searchKeyword) {
		if (log.isInfoEnabled())
			log.info("called getList() : bbsId=" + bbsId + ", pageNo=" + pageNo
					+ ", searchKeyword=" + searchKeyword);
		List<Article> result = new ArrayList<Article>();
		result.add(new Article());
		return result;
	}

}
