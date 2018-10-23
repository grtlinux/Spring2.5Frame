package kame.spring.store.dao.ibatis;

import kame.spring.store.dao.PaymentInfoDao;
import kame.spring.store.domain.PaymentInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IBatisPaymentInfoDao extends SqlMapClientDaoSupport implements
		PaymentInfoDao {

	@Override
	public void insert(PaymentInfo paymentInfo) {
		getSqlMapClientTemplate().insert("PaymentInfo.insert", paymentInfo);
	}

}
