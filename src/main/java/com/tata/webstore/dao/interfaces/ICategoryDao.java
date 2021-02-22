package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.Category;
import com.tata.webstore.domain.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
    public void addProduct(Product product) throws SQLException;

    void addSubCategory(int sup_id, int cat_id) throws SQLException;

    public Category getCategory(Long categoryId) throws SQLException;
    public List<Product> getProducts(Category category) throws SQLException;
    public List<Category> getSubCategories(Category category);
    public boolean hasProducts(Category category);
    public boolean hasSubcategories(Category category);
    public boolean removeProduct(Product product);
    public boolean updateCategory(Category category);

}
