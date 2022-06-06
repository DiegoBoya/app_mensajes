package com.diego.appMensajes.application.service;

import com.diego.appMensajes.application.DAO.MessageDAO;
import com.diego.appMensajes.application.model.Message;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {

    private static Scanner sc = new Scanner(System.in);

    public static void createMessage() {

        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Autor:");
        String nombre = sc.nextLine();

        Message registro = new Message();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MessageDAO.createMessage(registro);
    }

    public static void readMessages() {
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

    public static void deleteMessage() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese el ID del mensaje que desea eliminar.");
        System.out.println("para salir de esta seccion oprima 0");

        int messageToDelete = sc.nextInt();


        while (messageToDelete != 0 && messageToDelete < 1) {
            System.out.println("ID invalido, ingrese un numero de ID correcto u oprima 0 para salir");
            messageToDelete = sc.nextInt();
        }

        if (messageToDelete == 0) {
            System.out.println("Operacion abortada, no se ha eliminado ningun mensaje");
        } else {
            MessageDAO.deleteMessage(messageToDelete);
            System.out.println("el mensaje ha sido eliminado.");
        }

    }

    //todo: hacer que se borre el mensaje, pero que se imprima por consola lo que se borro
    public static void removeMessage() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese el ID del mensaje que desea eliminar.");
        System.out.println("para salir de esta seccion oprima 0");

        int messageToDelete = sc.nextInt();


       /* if (messageToDelete < 1 && messageToDelete != 0){
            System.out.println("ID invalido, ingrese un numero de ID correcto u oprima 0 para salir");
        }*/

       /* Message messageDeleted = MessageDAO.deleteMessage(messageToDelete);
        if ( messageDeleted != null){
            System.out.println("Mensaje eliminado:" + messageDeleted);
        }else{
            System.out.println( "ocurrio un error, no se elimino el mensaje");
        }*/

    }

    public static void editMessage() {

        //todo: validar el ID del msj por formato que no sea negativo
        System.out.println("ingrese el ID del mensaje que quiere editar");
        int idMessage = sc.nextInt();
        sc.nextLine();

        System.out.println("ingrese el nuevo mensaje");
        String newStringMessage = sc.nextLine();

        //crea un Message con el ID pasado de parametro y con el nuevo mensaje
        Message message = new Message();
        message.setIdMensaje(idMessage);
        message.setMensaje(newStringMessage);
        MessageDAO.updateMessage(message);
    }

}
