package com.everyday.dao;

import com.everyday.models.Category;

import java.sql.SQLException;
import java.util.List;

public abstract interface RetailDao {
    void addCategory(Category category) throws SQLException;

    List<? extends Category> getAllCategories(int type) throws SQLException;

    Category getCategoryId(long categoryId);
    boolean deleteCategory();
}
