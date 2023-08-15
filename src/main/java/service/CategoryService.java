package service;

import dataaccess.CategoryDb;
import models.Category;
import models.Item;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryService {
    CategoryDb categoryDb = new CategoryDb();

    public void createCategory(String name){
        Category category = new Category();
        category.setCategoryName(name);
        categoryDb.saveCategory(category);
    }

    public void createCategory(int categoryId, String name){
        Category category = categoryDb.findCategoryById(categoryId);
        category.setCategoryName(name);
        categoryDb.updateCategory(category);
    }
    public List<Category>  getAllCategory(){
        List<Category> categories = categoryDb.getAllCategory();
        return categories;
    }
    public List<Item> getAllItemInCategory(String name){
        Category category = categoryDb.findCategoryByName(name);
        return  category.getItemList();

    }
}
