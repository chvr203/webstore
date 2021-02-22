package com.tata.webstore.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class Catalog {
    private String name;
    private String description;
    private Set<Category> categorySet;
    private Images images;
}
