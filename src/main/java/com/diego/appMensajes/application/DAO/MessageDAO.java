package com.diego.appMensajes.application.DAO;

import com.diego.appMensajes.DB.connection.DBConnection;
import com.diego.appMensajes.application.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {




    public static void createMessage(Message message){
        DBConnection db_connect = new DBConnection();
        //realiza la conexion a la BD
        try(Connection conexion = db_connect.getConnection())  {
            PreparedStatement ps = null;
            try{
                //genera la query
                String query="INSERT INTO mensajes ( mensaje, autor_mensaje, fecha_mensaje) VALUES (?,?,CURRENT_TIMESTAMP)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, message.getMensaje());
                ps.setString(2, message.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");

            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void readMessage() {

    }

    public static void deleteMessage(int messageID) {

    }

    public static void updateMessage(Message message){

    }
}
