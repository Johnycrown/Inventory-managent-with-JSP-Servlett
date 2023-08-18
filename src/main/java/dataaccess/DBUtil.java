package dataaccess;

import models.Role;
import models.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("mypersistenceunit");


    public static EntityManagerFactory getEmFactory() {


        return entityManagerFactory;
    }
    public static Connection getConnectionUsingJDBC(){
        Connection connection = null;
        String jdbcUrl ="jdbc:mysql://localhost:3306/inventorydb";
        String username= "root";
        String  password = "mysql";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcUrl,username,password);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
