package kame.spring.bbs.domain.schedule;

import kame.spring.bbs.domain.service.InformMatchingItemService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class NotifyInterestItemJob extends QuartzJobBean {

	private Log log = LogFactory.getLog(getClass());

	private InformMatchingItemService informMatchingItemService;

	public void setInformMatchingItemService(
			InformMatchingItemService recommendItemService) {
		this.informMatchingItemService = recommendItemService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		log.info("executeInternal ½ÇÇà");
		informMatchingItemService.inform();
	}

}
