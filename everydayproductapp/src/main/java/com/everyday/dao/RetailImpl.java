package com.everyday.dao;

import com.everyday.helpers.DBConnHelper;
import com.everyday.models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RetailImpl implements RetailDao{
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement pre;
    private PreparedStatement epre;
    private PreparedStatement fpre;
    private PreparedStatement apre;
    private Statement statement;
    private ResultSet resultSet;


    public RetailImpl(){
        conn = DBConnHelper.getConnection();
        if(conn!=null){
            System.out.println("Connected to DB..");
        }else{
            System.out.println("DB Connection error.");
        }
        resourceBundle = ResourceBundle.getBundle("db");
    }
    @Override
    public void addCategory(Category category) throws SQLException {
        String addCategory = resourceBundle.getString("addCategory");
        String addElectronics = resourceBundle.getString("addElectronics");
        String addFoodItems = resourceBundle.getString("addFood");
        String addApparel = resourceBundle.getString("addApparel");

        try {
            pre = conn.prepareStatement(addCategory);
            epre = conn.prepareStatement(addElectronics);
            fpre = conn.prepareStatement(addFoodItems);
            apre = conn.prepareStatement(addApparel);

            pre.setLong(1, category.getItemCode());
            pre.setString(2, category.getItemName());
            pre.setLong(4, category.getUnitPrice());
            pre.setInt(3, category.getQuantity());
            pre.executeUpdate();

            if(category instanceof Electronics){
                epre.setLong(1,((Electronics) category).getItemCode());
                epre.setInt(2,((Electronics) category).getWarranty());
                epre.executeUpdate();
            }else if(category instanceof FoodItems){
                fpre.setDate(4, Date.valueOf(((FoodItems) category).getDoe()));
                fpre.setDate(3, Date.valueOf(((FoodItems) category).getDom()));
                fpre.setBoolean(2, ((FoodItems) category).isVegetarian());
                fpre.setLong(1,((FoodItems) category).getItemCode());
                fpre.executeUpdate();
            }else if(category instanceof Apparel){
                apre.setLong(1, ((Apparel) category).getItemCode());
                apre.setString(2, ((Apparel) category).getMaterial().toString());
                apre.setInt(3, ((Apparel) category).getSize());
                apre.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
                conn.rollback();
        }finally {
            conn.close();
        }
    }

    @Override
    public List<? extends Category> getAllCategories(int type) throws SQLException {
        conn = DBConnHelper.getConnection();

        List<Category> categoryList = new ArrayList<>();
        List<FoodItems> foodItemsList = new ArrayList<>();
        List<Electronics> electronicList = new ArrayList<>();
        List<Apparel> apparelList = new ArrayList<>();

        String query = null;

        switch (type){
            case 1:
                query = resourceBundle.getString("selectFoodItems");
                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    FoodItems foodItems = new FoodItems();
                    foodItems.setItemCode(resultSet.getLong(1));
                    foodItems.setItemName(resultSet.getString(2));
                    foodItems.setQuantity(resultSet.getInt(3));
                    foodItems.setUnitPrice(resultSet.getLong(4));
                    foodItems.setVegetarian(resultSet.getBoolean(5));
                    foodItems.setDom(resultSet.getDate(6).toLocalDate());
                    foodItems.setDoe(resultSet.getDate(7).toLocalDate());
                    foodItemsList.add(foodItems);
                }
                categoryList.addAll(foodItemsList);
                break;
            case 2:
                query = resourceBundle.getString("selectElectronicItems");
                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    Electronics electronics = new Electronics();
                    electronics.setItemCode(resultSet.getLong(1));
                    electronics.setItemName(resultSet.getString(2));
                    electronics.setQuantity(resultSet.getInt(3));
                    electronics.setUnitPrice(resultSet.getLong(4));
                    electronics.setWarranty(resultSet.getInt(5));
                    electronicList.add(electronics);
                }
                categoryList.addAll(electronicList);
                break;
            case 3:
                query = resourceBundle.getString("selectApparelItems");
                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    Apparel apparel = new Apparel();
                    apparel.setItemCode(resultSet.getLong(1));
                    apparel.setItemName(resultSet.getString(2));
                    apparel.setQuantity(resultSet.getInt(3));
                    apparel.setUnitPrice(resultSet.getLong(4));
                    apparel.setSize(resultSet.getInt(5));
                    apparel.setMaterial(Material.valueOf(resultSet.getString(6)));
                    apparelList.add(apparel);
                }
                categoryList.addAll(apparelList);
                break;
        }

        return categoryList;
    }

    @Override
    public Category getCategoryId(long categoryId) {
        return null;
    }

    @Override
    public boolean deleteCategory() {
        return false;
    }
}
