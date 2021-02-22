package com.tata.webstore.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private double cost;
    private Long units;
    private Set<Item> items;
    private Images images;
}
