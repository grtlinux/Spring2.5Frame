package kame.spring.express;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CompleteDeliveryListener {

	private Log log = LogFactory.getLog(getClass());
	
	public void listen(String invoiceNo) {
		log.debug("배송 완료:"+invoiceNo);
	}
}
