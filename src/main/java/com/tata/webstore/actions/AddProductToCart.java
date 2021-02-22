package com.tata.webstore.actions;

import com.tata.webstore.domain.entities.Cart;
import com.tata.webstore.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AddProductToCart {

    public Cart execute(Cart cart,Long qty, Product product){
        cart.addProduct(product,qty);
        return cart;
    }
}
