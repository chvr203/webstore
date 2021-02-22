package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.*;

public interface IWebStoreFacade {
    Address createAddress();
    Catalog createCatalog();
    Category createCategory();
    Cart createCart();
    CreditCard createCreditCard();
    Item createItem();
    Image createImage();
    Product createProduct();
    Order createOrder();
    UserAccount createUserAccount();
}
