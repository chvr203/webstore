package com.tata.webstore.actions;

import com.tata.webstore.domain.entities.Cart;
import com.tata.webstore.domain.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddItemsToCart {

    public Cart execute(Cart cart, Item item){
        cart.addItem(item);
        return cart;
    }
}
