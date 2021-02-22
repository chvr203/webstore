package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.Order;
import com.tata.webstore.domain.entities.UserAccount;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDao {
    public void addOrder(Order order) throws SQLException;
    public Order getOrder(Long orderId) throws SQLException;
    public List<Order> getOrders(UserAccount user) throws SQLException;

}
