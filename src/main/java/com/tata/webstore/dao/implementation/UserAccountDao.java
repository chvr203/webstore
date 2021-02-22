package com.tata.webstore.dao.implementation;

import com.tata.webstore.dao.interfaces.IUserAccountDao;
import com.tata.webstore.domain.entities.Address;
import com.tata.webstore.domain.entities.UserAccount;
import com.tata.webstore.helpers.DBConnHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserAccountDao implements IUserAccountDao {
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement preparedStatement;

    UserAccountDao() {
        conn = DBConnHelper.getConnection();
        if (conn != null) {
            System.out.println("Connected to DB..");
        } else {
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public void adduser(UserAccount userAccount) throws SQLException {
        String query = resourceBundle.getString("addUser");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, userAccount.getFirstName());
        preparedStatement.setString(2, userAccount.getLastName());
        preparedStatement.setString(3, userAccount.getEmailId());
        preparedStatement.setLong(4, userAccount.getAddress().getAddressId());
        preparedStatement.setString(5, userAccount.getUserName());
        preparedStatement.setString(6, userAccount.getPassword());
        preparedStatement.execute();
        conn.close();
    }

    @Override
    public UserAccount getUserAccount(Long userId) throws SQLException {

        String query = resourceBundle.getString("selectUser");
        preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, userId);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.executeQuery(query);
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        userAccount.setFirstName(resultSet.getString(1));
        userAccount.setLastName(resultSet.getString(2));
        userAccount.setEmailId(resultSet.getString(3));
        userAccount.setAddress(new Address().setAddressId(resultSet.getLong(4)));
        userAccount.setPassword(resultSet.getString(5));
        userAccount.setUserName(resultSet.getString(6));
        conn.close();
        return userAccount;
    }
}
