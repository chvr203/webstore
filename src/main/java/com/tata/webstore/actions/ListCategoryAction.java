package com.tata.webstore.actions;

import com.tata.webstore.helpers.DBConnHelper;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ResourceBundle;

@NoArgsConstructor
public class ListCategoryAction {
    private Connection conn;
    private PreparedStatement catalogPreparedStatement;
    private ResourceBundle resourceBundle;
    private Statement statement;
    private ResultSet resultSet;

    public void ListCategoryAction() throws SQLException {
        conn= DBConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");

        String query = resourceBundle.getString("listSubcat");
        catalogPreparedStatement = conn.prepareStatement(query);
        catalogPreparedStatement.execute();
        resultSet = statement.executeQuery(query);

        while(!resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }

    }
}
