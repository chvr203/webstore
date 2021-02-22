package com.tata.webstore.facade;

import com.tata.webstore.dao.interfaces.IWebStoreFacade;
import com.tata.webstore.domain.entities.*;

public class WebStorePOJO implements IWebStoreFacade {
        @Override
        public Address createAddress() {
            return new Address();
        }

        @Override
        public Catalog createCatalog() {
            return new Catalog();
        }

        @Override
        public Category createCategory() {
            return new Category();
        }

        @Override
        public Cart createCart() {
            return new Cart();
        }

        @Override
        public CreditCard createCreditCard() {
            return new CreditCard();
        }

        @Override
        public Item createItem() {
            return new Item();
        }

        @Override
        public Image createImage() {
            return new Image();
        }

        @Override
        public Product createProduct() {
            return new Product();
        }

        @Override
        public Order createOrder() {
            return new Order();
        }

        @Override
        public UserAccount createUserAccount() {
            return new UserAccount();
        }
}
