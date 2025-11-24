package com.biblioteca.model;

public class Permiso {
    private String nombre;
    private boolean estado;
    
    public Permiso(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
