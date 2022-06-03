package com.diego.appMensajes.DB.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection getConnection(){
        Connection connection = null;

        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app",
                        "root",
                        "");

                if(connection != null){
                    System.out.println("connection succes!");
                } else{
                    throw new SQLException("SQL error - try again.");
                }
            } catch (Exception e){
                System.out.println("error during the connection to the DB" + e);
            }
        }


        return connection;
    }

}
