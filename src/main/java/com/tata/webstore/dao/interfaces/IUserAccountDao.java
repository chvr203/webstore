package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.UserAccount;

import java.sql.SQLException;

public interface IUserAccountDao {
    public void adduser(UserAccount userAccount) throws SQLException;
    public UserAccount getUserAccount(Long userId) throws SQLException;
}
