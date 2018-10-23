package kame.spring.store.dao.hibernate;

import kame.spring.store.dao.PaymentInfoDao;
import kame.spring.store.domain.PaymentInfo;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernatePaymentInfoDao extends HibernateDaoSupport implements
		PaymentInfoDao {

	@Override
	public void insert(PaymentInfo paymentInfo) {
		getHibernateTemplate().save(paymentInfo);
	}

}
