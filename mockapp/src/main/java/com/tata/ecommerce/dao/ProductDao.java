package com.tata.ecommerce.dao;


import com.tata.ecommerce.models.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
}
