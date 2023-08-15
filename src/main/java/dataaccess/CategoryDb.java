package dataaccess;

import models.Category;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryDb {


    public void saveCategory(Category category ){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void updateCategory(Category category){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(category);
            entityTransaction.commit();
        } catch (Exception e) {

            entityTransaction.rollback();

            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Category findCategoryById(int categoryId){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();


        try{
            Category catgory =    entityManager.find(Category.class, categoryId);
            return catgory;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return null;
    }
    public Category findCategoryByName(String categoryName){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();


        try{
            Category catgory =    entityManager.find(Category.class, categoryName);
            return catgory;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return null;
    }
    public List<Category> getAllCategory(){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        List<Category> categories = entityManager.createNamedQuery("Category.findAll", Category.class).getResultList();
    return categories;}

}
