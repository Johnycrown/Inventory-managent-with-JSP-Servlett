package service;

import dataaccess.CategoryDb;
import dataaccess.ItemsDb;
import dataaccess.UserDb;
import models.Category;
import models.Item;
import models.User;

import java.util.List;

public class UserService {
    UserDb userDb = new UserDb();
    public void registerUser(String email, boolean active, String firstName, String lastName, String password){


        User user = new User(email,active,firstName,lastName,password);
        userDb.saveUser(user);


    }

    public void updateUser(String email, boolean active, String firstName, String lastName, String password){
        User savedUser = userDb.findUser(email);
        savedUser.setFirstName(firstName);
        savedUser.setLastName(lastName);
        savedUser.setPassword(password);
        userDb.updateUser(savedUser);
    }

    public List<Item>   getAllItems(String email){

      User user =  userDb.findUser(email);
      return user.getItemList();
    }

    public void addItem(String email, int itemId, String itemName, int price , String categoryName ){
        ItemsDb itemsDb = new ItemsDb();
        CategoryDb categoryDb = new CategoryDb();
       Category category = categoryDb.findCategoryByName(categoryName);
       User user = userDb.findUser(email);

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setCategory(category);
        item.setOwner(user);
        itemsDb.saveItem(item);
       // item.setItemId(itemId);
        user.addSingleItem(item);
        userDb.updateUser(user);

    }

    public void removeItem(String email, int itemdId){
        ItemsDb itemsDb = new ItemsDb();
       Item savedItem = itemsDb.findItem(itemdId);
        User user = userDb.findUser(email);
        user.getItemList().remove(savedItem);
        userDb.updateUser(user);


    }

    public void activateAccount(String email){
        User user = userDb.findUser(email);
        user.setActive(true);
        userDb.updateUser(user);
    }

    public void deActivateAccount(String email){
        User user = userDb.findUser(email);
        user.setActive(false);
        userDb.updateUser(user);
    }
}
