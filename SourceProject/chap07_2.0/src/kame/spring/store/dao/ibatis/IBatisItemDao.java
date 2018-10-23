package kame.spring.store.dao.ibatis;

import kame.spring.store.dao.ItemDao;
import kame.spring.store.domain.Item;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IBatisItemDao extends SqlMapClientDaoSupport implements ItemDao {

	@Override
	public Item findById(Integer itemId) {
		return (Item) getSqlMapClientTemplate().queryForObject("Item.findById",
				itemId);
	}

}
