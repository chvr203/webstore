package com.tata.webstore.domain.entities;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Images images;
    private boolean available;
    private Product product;
}
