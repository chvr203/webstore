package com.tata.webstore.dao.implementation;

import com.tata.webstore.dao.interfaces.IItemDao;
import com.tata.webstore.domain.entities.Item;
import com.tata.webstore.helpers.DBConnHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemDao implements IItemDao {

    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement preparedStatement;
    private PreparedStatement pre;

    ItemDao() {
        conn = DBConnHelper.getConnection();
        if (conn != null) {
            System.out.println("Connected to DB..");
        } else {
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public Item getItem(Long itemId) throws SQLException {
        String query = resourceBundle.getString("selectItem");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, itemId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.executeQuery(query);

        Item item = new Item();
        item.setPrice(resultSet.getDouble(2));
        item.setAvailable(resultSet.getBoolean(3));
        conn.close();
        return item;
    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }
}
