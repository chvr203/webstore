package com.tata.webstore.domain.entities;

import java.util.List;

public class Cart {
    private List<CartProduct> products;
    private List<Item> items;

    public void addProduct(Product product){
        CartProduct cp = new CartProduct();
        cp.setProduct(product);
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
        return products.indexOf(cp);
    }
    public boolean addItem(Item item){
        return true;
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
