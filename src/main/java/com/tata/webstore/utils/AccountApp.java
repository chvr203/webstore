package com.tata.webstore.utils;

import com.tata.webstore.actions.*;
import com.tata.webstore.dao.implementation.CatalogDao;
import com.tata.webstore.dao.implementation.CategoryDao;
import com.tata.webstore.dao.implementation.ProductDao;
import com.tata.webstore.dao.implementation.UserAccountDao;
import com.tata.webstore.dao.interfaces.ICatalogDao;
import com.tata.webstore.dao.interfaces.ICategoryDao;
import com.tata.webstore.dao.interfaces.IProductDao;
import com.tata.webstore.dao.interfaces.IUserAccountDao;
import com.tata.webstore.domain.entities.*;
import com.tata.webstore.facade.WebStorePOJO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class AccountApp {
    public static void main(String [] args) {
        WebStorePOJO webStorePOJO = new WebStorePOJO();

        Address address = webStorePOJO.createAddress();
        UserAccount userAccount = webStorePOJO.createUserAccount();
        CreditCard creditCard = webStorePOJO.createCreditCard();
        Product product = webStorePOJO.createProduct();
        Item item = webStorePOJO.createItem();
        Cart cart = webStorePOJO.createCart();

        address.setAddressId(2L);
        address.setAddress("Door No.1");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setType("Home");
        address.setZip(98320L);

        userAccount.setUserId(1L);
        userAccount.setFirstName("Johny");
        userAccount.setLastName("Depp");
        userAccount.setEmailId("johnydepp@gmail.com");
        userAccount.setAddress(address);
//      try {
//            UserAccountDao userAccountDao = new UserAccountDao();
//           // userAccountDao.adduser(userAccount);
//      } catch (SQLException throwables) {
//            throwables.printStackTrace();
//      }
        creditCard.setCardId(1L);
        creditCard.setCardType("Credit");
        creditCard.setCreditCardNumber(987612347654L);
        creditCard.setExpiryDate(Date.valueOf(LocalDate.now()));

        product.setId(1L);
        product.setName("Shoe");
        product.setCost(2999);
        product.setDescription("Footwear");
        product.setUnits(23L);
//        try {
//            ICategoryDao categoryDao = new CategoryDao();
//            categoryDao.addProduct(product);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        item.setProduct(product);
        item.setAvailable(true);
        item.setPrice(2999);
        item.setName("Nike Air Jordans");
        item.setDescription("Nike Footwear for Men.");
//        try {
//            IProductDao categoryDao = new ProductDao();
//            categoryDao.addItem(item);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//


        DisplayProductAction dpa = new DisplayProductAction();
        try {
            dpa.DisplayProductAction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DisplayItemAction dia = new DisplayItemAction();
        try {
            dia.DisplayItemAction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        AddItemsToCart addItemsToCart = new AddItemsToCart();
        addItemsToCart.execute(cart, item);

        AddProductToCart addProductToCart = new AddProductToCart();
        addProductToCart.execute(cart,1L,product);


        ClearCartAndOrderAction orderAction = new ClearCartAndOrderAction();
        orderAction.execute(cart,creditCard,userAccount,address);
    }
}
