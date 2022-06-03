package com.diego.appMensajes.application.service;

import com.diego.appMensajes.application.DAO.MessageDAO;
import com.diego.appMensajes.application.model.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    private static Scanner sc = new Scanner(System.in);

    public static void createMessage(){

        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Autor:");
        String nombre = sc.nextLine();

        Message registro = new Message();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MessageDAO.createMessage(registro);
    }

    public static void readMessages(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("obteniendo los mensajes de la BD....");

        //recibe la lista de mensajes que MessageDAO obtiene de la DB
        ArrayList<Message> messages = MessageDAO.readMessage();


        //imprime los registros
        for (Message m : messages) {
            System.out.println(m.toString());
            System.out.println("\n");
        }
        System.out.println("------------------fin de la lectura-------------------------");
    }

    public static void deleteMessage(){

    }

    public static void editMessage(){

    }

}
