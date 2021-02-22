package com.tata.webstore.domain.entities;

import java.util.List;

public class Cart {
    private List<CartProduct> products;
    private List<Item> items;

    public boolean addProduct(){
        return true;
    }

    public boolean setProductQuantity(){
        return true;
    }

    public boolean removeProduct(){
        return true;
    }

//    public Product getCartProduct(){
//
//    }
//
//    public boolean addItem(){
//        return true;
//    }
//
//    public boolean removeItem(){
//        return true;
//    }
//
//    public Item getCartItem(){
//
//    }
//
//    public int getItemCount(){
//
//    }
//
//    public long getItemTotal(){
//
//    }
//
//    public List<Long> getProductIDs(){
//
//    }
}
