package com.biblioteca.model;

public class Categoria {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
