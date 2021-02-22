package com.tata.webstore.dao.interfaces;

import com.tata.webstore.domain.entities.Catalog;
import com.tata.webstore.domain.entities.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICatalogDao {
    public void addCatalog(Catalog catalog) throws SQLException;
    public void addCategory(Category category) throws SQLException;

    Catalog getCatalog(long catalog_id) throws SQLException;

    public List<Catalog> getCatalogs() throws SQLException;
    List<Category> getCategories() throws SQLException;

    public boolean removeCatalog(Catalog catalog);
    public boolean removeCategory(Category category);
    public boolean updateCatalog(Catalog catalog);
}
