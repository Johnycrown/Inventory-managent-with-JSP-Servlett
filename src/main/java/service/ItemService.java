package service;

import dataaccess.DBUtil;
import dataaccess.ItemsDb;
import models.Category;
import models.Item;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    ItemsDb itemsDb = new ItemsDb();


    public void insertItem(Item item){

        itemsDb.saveItem(item);
    }

    public void updateItem(Item item ){

        itemsDb.updateItem(item);
    }

    public void  deleteItem(int itemeId){
        Item item = itemsDb.findItem(itemeId);
        itemsDb.deleteItem(item);
    }

    public Item findItem(int id){
        Item savedItem = itemsDb.findItem(id);
        return savedItem;
    }
    public List<Item> getAllItemByEmailUsingJDBC(String email) throws SQLException {
        List<Item> items = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            String sql = "SELECT * FROM item WHERE owner=?";
             connection = DBUtil.getConnectionUsingJDBC();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
             resultSet = preparedStatement.executeQuery();
            //System.out.println("resulset is \n\n"+ resultSet.getInt(1) );
            while (resultSet.next()){
                System.out.println("resulset is \n\n"+ resultSet );
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                Category category =  resultSet.getObject(4, Category.class);
                User user = resultSet.getObject(5, User.class);
                Item item = new Item(id,name,price);
                item.setCategory(category);
                item.setOwner(user);
                items.add(item);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            resultSet.close();
            connection.close();
        }
        return items;
    }
}
