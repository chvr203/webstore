package com.java.cartapp.utility;

import com.java.cartapp.dao.CartDao;
import com.java.cartapp.dao.CartImpl;
import com.java.cartapp.dao.OrderDao;
import com.java.cartapp.dao.OrderImpl;
import com.java.cartapp.models.Cart;
import com.java.cartapp.models.Product;

public class BillingApp {
    private static void main(String args[]){
        Thread.currentThread().getName();
        OrderDao orderDao =  new OrderImpl();
        for(int i=0; i<5; i++){
            orderDao.bookOrder(createCart());
        }
        orderDao.viewOrders().entrySet().stream().forEach(System.out::println);
    }
    private Cart createCart(){
        CartDao cartDao = new CartImpl()pl();
        Product product = null;
        for(int i=0; i<10; i++){

        }
    }
}
