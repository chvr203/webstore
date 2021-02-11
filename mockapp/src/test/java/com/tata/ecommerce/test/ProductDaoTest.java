package com.tata.ecommerce.test;

import com.tata.ecommerce.dao.ProductDao;
import com.tata.ecommerce.dao.ProductImpl;
import com.tata.ecommerce.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductDaoTest {
    @Test
    public void mockGetAllProducts(){
        ProductDao productDao = mock(ProductImpl.class);
        List<Product> productList = new ArrayList<>();
        for(int i=0; i<10; i++){
            productList.add(new Product());
        }
        when(productDao.getAllProducts()).thenReturn(productList);
        assertTrue(productDao.getAllProducts().size()>0);
    }
}