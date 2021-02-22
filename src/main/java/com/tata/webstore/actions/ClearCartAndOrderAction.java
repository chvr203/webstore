package com.tata.webstore.actions;

import com.tata.webstore.dao.implementation.OrderDao;
import com.tata.webstore.dao.interfaces.IOrderDao;
import com.tata.webstore.domain.entities.*;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
public class ClearCartAndOrderAction {
    public void execute(Cart cart, CreditCard creditCard, UserAccount userAccount, Address address){

        Order order = new Order();
        order.setOrderStatus(true);
        order.setUserAccount(userAccount);
        order.setCreditCard(creditCard);
        order.setShippingAddress(address);
        order.setOrderDate(Date.valueOf(LocalDate.now()));
        order.setCart(cart);

        IOrderDao orderDao = new OrderDao();
        try {
            orderDao.addOrder(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
