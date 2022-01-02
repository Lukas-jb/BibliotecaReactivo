package com.co.app.biblioteca.utils;

public class Mensaje {

    private boolean disponible;
    private String mensaje;

    public Mensaje(boolean disponible, String mensaje) {
        this.disponible = disponible;
        this.mensaje = mensaje;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setDisponible(boolean estado) {
        this.disponible = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}