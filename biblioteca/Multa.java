package biblioteca;

import java.util.Date;

public class Multa {
    private Usuario usuario;
    private float monto;
    private Date fechaEmision;
    private Prestamo prestamo;
    private boolean pagada;
    private Bibliotecario emisor;

    public Multa(Usuario usuario, float monto, Date fechaEmision, boolean pagada) {
        this.usuario = usuario;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.pagada = pagada;
        this.prestamo = null;
        this.emisor = null;
    }

    public void registrarPago() {
        this.pagada = true;
    }

    public void calcularMonto(Prestamo prestamo) {
        this.prestamo = prestamo;
        // Cálculo del monto según el préstamo (implementación no especificada en el diagrama)
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public boolean isPagada() {
        return pagada;
    }

    public Bibliotecario getEmisor() {
        return emisor;
    }
}
