package dataaccess;

import models.Role;
import models.User;

import javax.persistence.EntityManager;

public class RoleDb {

    public Role findRole(int email){

        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();


        try{
            Role role =    entityManager.find(Role.class, email);
            return role;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            entityManager.close();
        }


    }
}
