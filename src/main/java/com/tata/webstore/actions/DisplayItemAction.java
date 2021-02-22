package com.tata.webstore.actions;

import com.tata.webstore.helpers.DBConnHelper;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ResourceBundle;

@NoArgsConstructor
public class DisplayItemAction {
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public void DisplayItemAction() throws SQLException {
        conn= DBConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");

        String query = resourceBundle.getString("listItem");
        statement = conn.prepareStatement(query);
        resultSet = statement.executeQuery();

        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }
}
