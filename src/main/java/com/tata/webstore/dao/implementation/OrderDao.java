package com.tata.webstore.dao.implementation;

import com.tata.webstore.dao.interfaces.IOrderDao;
import com.tata.webstore.domain.entities.Address;
import com.tata.webstore.domain.entities.CreditCard;
import com.tata.webstore.domain.entities.Order;
import com.tata.webstore.domain.entities.UserAccount;
import com.tata.webstore.helpers.DBConnHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderDao implements IOrderDao {

    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement preparedStatement;
    private PreparedStatement pre;

    OrderDao() {
        conn = DBConnHelper.getConnection();
        if (conn != null) {
            System.out.println("Connected to DB..");
        } else {
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        String query = resourceBundle.getString("addOrder");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setBoolean(2, order.isOrderStatus());
        preparedStatement.setDate(3, order.getOrderDate());
        preparedStatement.setLong(4, order.getUserAccount().getUserId());
        preparedStatement.setLong(5, order.getCreditCard().getCreditCardNumber());
        preparedStatement.setLong(6, order.getShippingAddress().getAddressId());
        preparedStatement.execute();
        conn.close();
    }

    @Override
    public Order getOrder(Long orderId) throws SQLException {
        String query = resourceBundle.getString("selectOrder");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, orderId);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.executeQuery(query);
        Order order = new Order();
        order.setOrderId(resultSet.getLong(1));
        order.setOrderStatus(resultSet.getBoolean(2));
        order.setOrderDate(resultSet.getDate(3));
        order.setUserAccount(new UserAccountDao().getUserAccount(resultSet.getLong(4)));
        order.setCreditCard(new CreditCard());
        order.setShippingAddress(new Address());

        return order;
    }

    @Override
    public List<Order> getOrders(UserAccount user) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        String query = resourceBundle.getString("selectOrderFromUser");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, user.getAddress().getAddressId());
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.executeQuery(query);
        while(resultSet.next()){
            orderList.add(getOrder(resultSet.getLong(1)));
        }
        return orderList;
    }
}
