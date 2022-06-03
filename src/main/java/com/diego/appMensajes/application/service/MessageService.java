package com.diego.appMensajes.application.service;

import com.diego.appMensajes.application.DAO.MessageDAO;
import com.diego.appMensajes.application.model.Message;

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

    public static void listMessages(){

    }

    public static void deleteMessage(){

    }

    public static void editMessage(){

    }

}
