package com.biblioteca.model;

import java.util.Date;

public class Multa {
    private UsuarioComun usuario;   // ← CAMBIO APLICADO
    private float monto;
    private Date fechaEmision;
    private Prestamo prestamo;
    private boolean pagada;
    private Bibliotecario emisor;

    public Multa(UsuarioComun usuario, float monto, Date fechaEmision, boolean pagada, Bibliotecario emisor, Prestamo prestamo) {  // ← CAMBIO APLICADO
        this.usuario = usuario;   // ← CAMBIO APLICADO
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.pagada = pagada;
        this.prestamo = prestamo;
        this.emisor = emisor;
    }

    public void registrarPago() {
        this.pagada = true;

        // Ya no es necesario el instanceof porque siempre es UsuarioComun
        usuario.limpiarMultas();   // ← CAMBIO APLICADO
    }

    public void calcularMonto(Prestamo prestamo) {
        this.prestamo = prestamo;

        Date fechaDevolucion = prestamo.getFechaDevolucion();
        Date fechaActual = new Date();

        long diffMilisegundos = fechaActual.getTime() - fechaDevolucion.getTime();
        long diffDias = diffMilisegundos / (1000 * 60 * 60 * 24);

        if (diffDias > 0) {
            float tarifaDiaria = 5.0f;
            this.monto = tarifaDiaria * diffDias;
        } else {
            this.monto = 0;
        }

        this.fechaEmision = fechaActual;
    }

    public UsuarioComun getUsuario() { return usuario; }   // ← CAMBIO APLICADO
    public float getMonto() { return monto; }
    public Date getFechaEmision() { return fechaEmision; }
    public Prestamo getPrestamo() { return prestamo; }
    public boolean isPagada() { return pagada; }
    public Bibliotecario getEmisor() { return emisor; }
}
