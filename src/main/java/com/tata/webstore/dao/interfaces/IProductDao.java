package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.Item;
import com.tata.webstore.domain.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    public void addItem(Item item) throws SQLException;
    public List<Item> getItems(Product product) throws SQLException;
    public Product getProduct(Long productId) throws SQLException;
}
