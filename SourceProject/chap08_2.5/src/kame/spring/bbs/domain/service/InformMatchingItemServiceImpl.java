package kame.spring.bbs.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InformMatchingItemServiceImpl implements InformMatchingItemService {

	private Log log = LogFactory.getLog(getClass());
	
	@Override
	public void inform() {
		log.info("��Ī�Ǵ� ��ǰ ���� ȸ������ ���Ϸ� ������!");
	}

}
