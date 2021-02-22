package com.tata.webstore.domain.entities;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private Long orderId;
    private UserAccount userAccount;
    private CreditCard creditCard;
    private Cart cart;
    private Address shippingAddress;
    private Date orderDate;
    private boolean orderStatus;
}
