package com.diego.appMensajes.application.model;

public class Message {
    private int idMensaje;
    private String mensaje;
    private String autorMensaje;
    private String fechaMensaje;


    public Message(){

    }

    public Message(int idMensaje, String mensaje, String autorMensaje, String fechaMensaje) {
        this.idMensaje = idMensaje;
        this.mensaje = mensaje;
        this.autorMensaje = autorMensaje;
        this.fechaMensaje = fechaMensaje;
    }

    public Message(String mensaje, String autorMensaje, String fechaMensaje) {
        this.mensaje = mensaje;
        this.autorMensaje = autorMensaje;
        this.fechaMensaje = fechaMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setAutorMensaje(String autorMensaje) {
        this.autorMensaje = autorMensaje;
    }

    public void setFechaMensaje(String fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getAutorMensaje() {
        return autorMensaje;
    }

    public String getFechaMensaje() {
        return fechaMensaje;
    }

    @Override
    public String toString() {
        return  "ID=" + idMensaje +
                " --- autor: " + autorMensaje + "\n" +
                "mensaje= [" + mensaje +"]" + "\n" +
                "fechaMensaje= [" + fechaMensaje +"]" + "\n" ;
    }
}
