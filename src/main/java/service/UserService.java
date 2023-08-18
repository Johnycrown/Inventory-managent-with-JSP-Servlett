package service;

import dataaccess.CategoryDb;
import dataaccess.ItemsDb;
import dataaccess.RoleDb;
import dataaccess.UserDb;
import models.Category;
import models.Item;
import models.User;

import java.util.List;

public class UserService {
    UserDb userDb = new UserDb();
    public void registerUser(String email, boolean active, String firstName, String lastName, String password, int roleId){
        RoleDb roleDb = new RoleDb();
        roleDb.findRole(roleId);


        User user = new User(email,active,firstName,lastName,password);
        user.setRole(  roleDb.findRole(roleId));
        userDb.saveUser(user);


    }

    public void updateUser(User user){
//        User savedUser = userDb.findUser(email);
//        savedUser.setFirstName(firstName);
//        savedUser.setLastName(lastName);
//        savedUser.setPassword(password);
        userDb.updateUser(user);
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
    public User login(String email, String password) {
        UserDb userDB = new UserDb();

        try {
            User user = userDB.findUser(email);
            if (password.equals(user.getPassword()) && user.getActive()) {
                return user;
            }
        } catch (Exception e) {
        }

        return null;
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
    public List<User> findAllUser(){
        List<User> users = userDb.findAllUser();
        return users;
    }
    public User findUserByEmail(String email){
        User user =  userDb.findUser(email);
        return user;
    }
    public void deleteUser(String email){
        User user =  userDb.findUser(email);
        ItemsDb itemsDb = new ItemsDb();
        List<Item> items = user.getItemList();
        for(Item item: items){
            itemsDb.deleteItem(item);
        }

        userDb.deleteUser(user);

    }
}
