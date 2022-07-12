package com.diego.appMensajes.application;

import com.diego.appMensajes.DB.connection.DBConnection;
import com.diego.appMensajes.application.service.MessageService;


import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DBConnection dbConnection = new DBConnection();

        int opcion = 0;

        do {

        System.out.println("===========================");
        System.out.println("Welcome! Coose an option:");
        System.out.println("1. create a message");
        System.out.println("2. list all the messages");
        System.out.println("3. edit a message");
        System.out.println("4. delete a message");
        System.out.println("5. remove message");
        System.out.println("6. exit");
        System.out.println("===========================");

        opcion = input.nextInt();

        switch (opcion){
            case 1:
                MessageService.createMessage();
                break;
            case 2:
                MessageService.readMessages();
                break;
            case 3:
                MessageService.editMessage();
                break;
            case 4:
                MessageService.deleteMessage();
                break;
            case 5:
                MessageService.removeMessage();
                break;
        }

        }while(opcion != 6);



       /* try{
            Connection cnx = dbConnection.getConnection();
        } catch(Exception e){
            System.out.println(e);
        }*/
    }
}
