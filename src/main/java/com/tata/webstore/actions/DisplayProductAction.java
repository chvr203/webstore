package com.tata.webstore.actions;

import com.tata.webstore.helpers.DBConnHelper;

import java.sql.*;
import java.util.ResourceBundle;

public class DisplayProductAction {
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public void DisplayProductAction() throws SQLException {
        conn= DBConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");

        String query = resourceBundle.getString("listProduct");
        statement = conn.prepareStatement(query);
        resultSet = statement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

    }
}
