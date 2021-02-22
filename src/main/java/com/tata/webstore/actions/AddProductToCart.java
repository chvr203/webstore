package com.tata.webstore.actions;

import com.tata.webstore.domain.entities.Cart;
import com.tata.webstore.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductToCart {
    Product product=new Product();
    int qty=0;

    public void AddProductToCart(int qty, Cart cart){
        cart.addProduct(product);
    }
}
