package com.tata.webstore.dao.implementation;

import com.tata.webstore.dao.interfaces.ICatalogDao;
import com.tata.webstore.domain.entities.Catalog;
import com.tata.webstore.domain.entities.Category;
import com.tata.webstore.helpers.DBConnHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CatalogDao implements ICatalogDao {
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement catalogPreparedStatement,categoryPreparedStatement;
    private PreparedStatement pre;

    CatalogDao() {
        conn = DBConnHelper.getConnection();
        if (conn != null) {
            System.out.println("Connected to DB..");
        } else {
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public void addCatalog(Catalog catalog) throws SQLException {
        String query = resourceBundle.getString("addCatalog");
        catalogPreparedStatement = conn.prepareStatement(query);
        catalogPreparedStatement.setString(1,catalog.getName());
        catalogPreparedStatement.setString(2,catalog.getDescription());
        catalogPreparedStatement.execute();
        conn.close();
    }

    @Override
    public void addCategory(Category category) throws SQLException {
        String query = resourceBundle.getString("addCategory");
        categoryPreparedStatement = conn.prepareStatement(query);
        categoryPreparedStatement.setString(1,category.getName());
        categoryPreparedStatement.setString(2,category.getDescription());
        catalogPreparedStatement.setLong(3, category.getSubCategory().getId());
        categoryPreparedStatement.execute();
        conn.close();
    }

    @Override
    public Catalog getCatalog(long catalog_id) throws SQLException{
        String query = resourceBundle.getString("selectCatalog");
        ResultSet resultSet;
        Catalog catalog = null;
        catalogPreparedStatement = conn.prepareStatement(query);
        catalogPreparedStatement.setLong(1, catalog_id);
        catalogPreparedStatement.executeUpdate();

        resultSet = catalogPreparedStatement.executeQuery(query);

        catalog = new Catalog();
        catalog.setName(resultSet.getString(2));
        catalog.setDescription(resultSet.getString(3));
        conn.close();

        return catalog;
    }

    @Override
    public List<Catalog> getCatalogs() throws SQLException {
        String query = resourceBundle.getString("selectCatalogs");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Catalog> catalogs = new ArrayList<Catalog>();
        while (resultSet.next()){
            Catalog rcatalog = new Catalog();
            rcatalog.setName(resultSet.getString(1));
            rcatalog.setDescription(resultSet.getString(2));
            catalogs.add(rcatalog);
        }
        conn.close();
        return catalogs;
    }

    @Override
    public List<Category> getCategories() throws SQLException {
        String query = resourceBundle.getString("selectCategories");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Category> categories = new ArrayList<Category>();
        while (resultSet.next()){
            Category rcatalog = new Category();
            rcatalog.setId(resultSet.getLong(1));
            rcatalog.setName(resultSet.getString(2));
            rcatalog.setDescription(resultSet.getString(3));
            long sup_id = resultSet.getLong(4);
            rcatalog.getSubCategory().setId(sup_id);
            categories.add(rcatalog);
        }
        conn.close();
        return categories;
    }

    @Override
    public boolean removeCatalog(Catalog catalog) {
        return false;
    }

    @Override
    public boolean removeCategory(Category category) {
        return false;
    }

    @Override
    public boolean updateCatalog(Catalog catalog) {
        return false;
    }
}
