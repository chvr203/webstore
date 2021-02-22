package com.tata.webstore.actions;

import com.tata.webstore.domain.entities.Cart;
import com.tata.webstore.domain.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddItemsToCart {
    Item item=new Item();
    Cart cart = new Cart();

    public void AddItemsToCart(Cart cart){
        cart.addItem(item);
    }
}
