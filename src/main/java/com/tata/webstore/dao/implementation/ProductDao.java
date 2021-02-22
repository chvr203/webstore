package com.tata.webstore.dao.implementation;

import com.tata.webstore.dao.interfaces.IProductDao;
import com.tata.webstore.domain.entities.Item;
import com.tata.webstore.domain.entities.Product;
import com.tata.webstore.helpers.DBConnHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductDao implements IProductDao {
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement preparedStatement;

    public ProductDao() {
        conn = DBConnHelper.getConnection();
        if (conn != null) {
            System.out.println("Connected to DB..");
        } else {
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public void addItem(Item item) throws SQLException {
        String query = resourceBundle.getString("addItem");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, item.getName());
        preparedStatement.setString(2, item.getDescription());
        preparedStatement.setDouble(3, item.getPrice());
        preparedStatement.setBoolean(4, item.isAvailable());
        preparedStatement.setLong(5,item.getProduct().getId());
        preparedStatement.execute();
        conn.close();
    }

    @Override
    public List<Item> getItems(Product product) throws SQLException {
        List<Item> items=new ArrayList<>();
        String query = resourceBundle.getString("selectItems");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, product.getId());
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.executeQuery(query);
        while(resultSet.next()){
            Item item=new Item();
            item.setId(resultSet.getLong(1));
            item.setPrice(resultSet.getDouble(2));
            item.setAvailable(resultSet.getBoolean(3));
            item.setProduct(new ProductDao().getProduct(resultSet.getLong(4)));
            items.add(item);
        }

        return items;
    }

    @Override
    public Product getProduct(Long productId) throws SQLException {

        Product product = null;
        String query = resourceBundle.getString("selectProduct");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, productId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.executeQuery(query);

        product = new Product();
        product.setId(productId);
        product.setName(resultSet.getString(2));
        product.setDescription(resultSet.getString(3));
        product.setCost(resultSet.getDouble(4));
        return product;
    }
}
