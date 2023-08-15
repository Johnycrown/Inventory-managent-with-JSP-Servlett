package service;

import dataaccess.ItemsDb;
import models.Item;

public class ItemService {

    ItemsDb itemsDb = new ItemsDb();


    public void insertItem(Item item){

        itemsDb.saveItem(item);
    }

    public void updateItem(Item item ){

        itemsDb.updateItem(item);
    }

    public void  deleteItem(Item item){
        itemsDb.deleteItem(item);
    }

    public Item findItem(int id){
        Item savedItem = itemsDb.findItem(id);
        return savedItem;
    }
}
