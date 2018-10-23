package kame.spring.bbs.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InformMatchingItemServiceImpl implements InformMatchingItemService {

	private Log log = LogFactory.getLog(getClass());
	
	@Override
	public void inform() {
		log.info("매칭되는 상품 정보 회원에게 메일로 전송함!");
	}

}
