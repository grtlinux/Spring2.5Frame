package kame.spring.store.dao;

import kame.spring.store.domain.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
