package com.tata.webstore.domain.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<CartProduct> products = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void addProduct(Product product, Long quantity){
        CartProduct cp = new CartProduct();
        cp.setProduct(product);
        cp.setQuantity(quantity);
        products.add(cp);
    }

    public boolean setProductQuantity(){
        return true;
    }

    public boolean removeProduct(){
        return true;
    }

    public Product getCartProduct(Product product){
        CartProduct cp  = products.stream().filter(cartp->cartp.getProduct().equals(product)).findFirst().orElse(null);
        return cp.getProduct();
    }
    public void addItem(Item item){
        items.add(item);
    }
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
