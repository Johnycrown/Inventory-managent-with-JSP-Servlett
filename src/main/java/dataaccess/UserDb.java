package dataaccess;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDb {


    public void saveUser(User user ){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user);
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

    public void updateUser(User user){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
        } catch (Exception e) {

                entityTransaction.rollback();

            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public User findUser(String email){

        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();


        try{
        User user =    entityManager.find(User.class, email);
        return user;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            entityManager.close();
        }


    }

    public void deleteUser(User user){
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.remove(user);
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
