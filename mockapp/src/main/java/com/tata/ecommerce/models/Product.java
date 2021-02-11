package com.tata.ecommerce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private long ProductId;
    private String name;
    private LocalDate dop;
    private long cost;
}
