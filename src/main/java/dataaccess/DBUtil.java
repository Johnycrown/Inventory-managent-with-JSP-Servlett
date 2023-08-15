package dataaccess;

import models.Role;
import models.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("my_persistence_unit");


    public static EntityManagerFactory getEmFactory() {


        return entityManagerFactory;
    }
}
