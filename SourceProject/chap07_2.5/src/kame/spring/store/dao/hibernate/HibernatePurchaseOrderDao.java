package kame.spring.store.dao.hibernate;

import kame.spring.store.dao.PurchaseOrderDao;
import kame.spring.store.domain.PurchaseOrder;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernatePurchaseOrderDao extends HibernateDaoSupport implements
		PurchaseOrderDao {

	@Override
	public void insert(PurchaseOrder order) {
		getHibernateTemplate().save(order);
	}

}
