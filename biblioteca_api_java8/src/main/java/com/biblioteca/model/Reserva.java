package com.biblioteca.model;

import java.util.Date;

public class Reserva {
    private Libro libro;
    private UsuarioComun usuario;   // ← CAMBIO APLICADO
    private Date fechaReserva;
    private boolean activa;
    private Bibliotecario emisor;

    public Reserva(Libro libro, UsuarioComun usuario, Date fechaReserva, Bibliotecario emisor) {  // ← CAMBIO APLICADO
        this.libro = libro;
        this.usuario = usuario;   // ← CAMBIO APLICADO
        this.fechaReserva = fechaReserva;
        this.activa = true;
        this.emisor = emisor;
    }

    public Libro getLibro() {
        return libro;
    }

    public UsuarioComun getUsuario() {   // ← CAMBIO APLICADO
        return usuario;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public boolean isActiva() {
        return activa;
    }

    public Bibliotecario getEmisor() {
        return emisor;
    }
    
    public void cancelarReserva() {
        this.activa = false;
    }
}
