package com.diego.appMensajes.application.DAO;

import com.diego.appMensajes.DB.connection.DBConnection;
import com.diego.appMensajes.application.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {


    private static Connection conexion = getDBConnection();

    private static PreparedStatement ps = null;

    private static Connection getDBConnection(){
        if(conexion == null){
            DBConnection db_connect = new DBConnection();
            //realiza la conexion a la BD
            conexion = db_connect.getConnection();
        }
        return conexion;
    }

    public static void createMessage(Message message){
            try{
                //genera la query
                String query="INSERT INTO mensajes ( mensaje, autor_mensaje, fecha_mensaje) VALUES (?,?,CURRENT_TIMESTAMP)";
                ps= conexion.prepareStatement(query);
                ps.setString(1, message.getMensaje());
                ps.setString(2, message.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");

            }catch(SQLException ex){
                System.out.println(ex);
            }

    }

    public static ArrayList<Message> readMessage() {

        ArrayList<Message> messages = new ArrayList<>();

        try{
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);

            //permite obtener los datos consultados en forma de ResultSet
            ResultSet rs = ps.executeQuery();

            //recorremos el ResultSet y lo guardamos en una lista para enviar a MessageService

            while(rs.next()){
                Message m = new Message();
                m.setIdMensaje(rs.getInt("id_mensaje"));
                m.setMensaje(rs.getString("mensaje"));
                m.setAutorMensaje(rs.getString("autor_mensaje"));
                m.setFechaMensaje(rs.getString("fecha_mensaje"));
                messages.add(m);
            }

        }catch(SQLException e){
            System.out.println("Error al intentar leer la DB.");
            System.out.println(e);
        }

        return messages;
    }

    public static void deleteMessage(int messageID) {
        try{
            String query = "DELETE FROM mensajes where id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, messageID);
            int i = ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Error al intentar leer la DB.");
            System.out.println(e);
        }
    }

    /**
     * TO DO: ELIMINAR EL MENSAJE HABIENDO OBTENIDO ANTES EL MENSAJE
     * @param messageID
     * @return el Message eliminado
     */
    public static Message removeMessage(int messageID) {
    // PARECE QUE TIENE PROBLEMA, COMO QUE PS NO PUEDE HACER 2 QUERYS SEGUIDAS, TIRA UN SQLEXCEPTION
        Message message = null;
        try{
            String query = "DELETE FROM mensajes where id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, messageID);
            // message = getMessageById(messageID);
            int i = ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Error al intentar leer la DB.");
            System.out.println(e);
        }
        return message;
    }

    public static Message getMessageById(int messageID) {

        Message m = new Message();
        //ArrayList<Message> messages = new ArrayList<>();

        try{
            String query = "SELECT * FROM mensajes where id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, messageID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                m.setIdMensaje(rs.getInt("id_mensaje"));
                m.setMensaje(rs.getString("mensaje"));
                m.setAutorMensaje(rs.getString("autor_mensaje"));
                m.setFechaMensaje(rs.getString("fecha_mensaje"));
            }


        }catch(SQLException e){
            System.out.println("ID no encontrado.");
            System.out.println(e);
        }

        return m;
    }

    public static void updateMessage(Message message){

    }
}
