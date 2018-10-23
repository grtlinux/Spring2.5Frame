package kame.spring.store.dao.ibatis;

import kame.spring.store.dao.PurchaseOrderDao;
import kame.spring.store.domain.PurchaseOrder;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IBatisPurchaseOrderDao extends SqlMapClientDaoSupport implements
		PurchaseOrderDao {

	@Override
	public void insert(PurchaseOrder order) {
		getSqlMapClientTemplate().insert("PurchaseOrder.insert", order);
	}

}
