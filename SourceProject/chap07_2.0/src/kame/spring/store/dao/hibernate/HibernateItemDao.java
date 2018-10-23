package kame.spring.store.dao.hibernate;

import kame.spring.store.dao.ItemDao;
import kame.spring.store.domain.Item;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateItemDao extends HibernateDaoSupport implements ItemDao {

	@Override
	public Item findById(Integer itemId) {
		return (Item) getHibernateTemplate().get(Item.class, itemId);
	}

}
