package com.tata.webstore.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class Category {
    private Long Id;
    private String name;
    private String description;
    private Set<Product> products;
    private Images images;
    private Category subCategory;
}
