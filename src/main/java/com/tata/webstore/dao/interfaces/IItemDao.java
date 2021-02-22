package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.Item;

import java.sql.SQLException;

public interface IItemDao {

    Item getItem(Long itemId) throws SQLException;

    public boolean updateItem(Item item);
}
