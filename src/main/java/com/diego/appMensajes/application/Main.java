package com.diego.appMensajes.application;

import com.diego.appMensajes.DB.connection.DBConnection;


import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        DBConnection dbConnection = new DBConnection();

        try{
            Connection cnx = dbConnection.getConnection();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
