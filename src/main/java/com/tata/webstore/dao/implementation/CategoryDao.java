package com.tata.webstore.dao.implementation;

import com.tata.webstore.dao.interfaces.ICategoryDao;
import com.tata.webstore.domain.entities.Category;
import com.tata.webstore.domain.entities.Product;
import com.tata.webstore.helpers.DBConnHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryDao implements ICategoryDao {

    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement preparedStatement;

    public CategoryDao() {
        conn = DBConnHelper.getConnection();
        if (conn != null) {
            System.out.println("Connected to DB..");
        } else {
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        String query = resourceBundle.getString("addProduct");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,product.getDescription());
        preparedStatement.setDouble(3, product.getCost());
        preparedStatement.setLong(4, product.getUnits());
        preparedStatement.execute();
    }

    @Override
    public void addSubCategory(int sup_id, int cat_id) throws SQLException {
        String query = resourceBundle.getString("addSubCategory");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, sup_id);
        preparedStatement.setInt(2, cat_id);
        preparedStatement.execute();
        conn.close();
    }

    @Override
    public Category getCategory(Long categoryId) throws SQLException {
        String query = resourceBundle.getString("selectCategory");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, categoryId);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.executeQuery(query);
        Category category=null;

        if(!resultSet.next())
            return category;

        category.setName(resultSet.getString(2));
        category.setDescription(resultSet.getString(3));
        conn.close();

        return category;
    }

    @Override
    public List<Product> getProducts(Category category) throws SQLException {
        List<Product> products=new ArrayList<>();
        String query = resourceBundle.getString("selectProdFromCat");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, category.getId());
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.executeQuery(query);
        if(!resultSet.next()){
            return products;
        }
        while ((resultSet.next())){
            Product product = new ProductDao().getProduct(resultSet.getLong(4));
            products.add(product);

        }
        return products;
    }

    @Override
    public List<Category> getSubCategories(Category category) {
        return null;
    }

    @Override
    public boolean hasProducts(Category category) {
        return false;
    }

    @Override
    public boolean hasSubcategories(Category category) {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean removeProduct(Product product) {
        return false;
    }
}
