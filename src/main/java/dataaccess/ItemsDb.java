package dataaccess;

import models.Category;
import models.Item;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ItemsDb {
    public void saveItem(Item item ){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(item);
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

    public void updateItem(Item item){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(item);
            entityTransaction.commit();
        } catch (Exception e) {

            entityTransaction.rollback();

            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Item findItem(int itemId){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();


        try{
            Item item =    entityManager.find(Item.class, itemId);
            return item;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    public void deleteItem(Item item){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.remove(item);
            entityTransaction.commit();
        }
        catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }

}
