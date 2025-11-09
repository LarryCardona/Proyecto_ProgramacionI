package biblioteca;

import java.util.Date;

public class Multa {
    private Usuario usuario;
    private float monto;
    private Date fechaEmision;
    private Prestamo prestamo;
    private boolean pagada;
    private Bibliotecario emisor;

    public Multa(Usuario usuario, float monto, Date fechaEmision, boolean pagada, Bibliotecario emisor, Prestamo prestamo) {
        this.usuario = usuario;
        this.monto = monto;
        this.fechaEmision = fechaEmision;
        this.pagada = pagada;
        this.prestamo = prestamo;
        this.emisor = emisor;
    }

    public void registrarPago() {
        this.pagada = true;

        // ✅ Compatible con Java 8 / 11
        if (usuario instanceof UsuarioComun) {
            UsuarioComun uc = (UsuarioComun) usuario;
            uc.limpiarMultas();
        }
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

    public Usuario getUsuario() { return usuario; }
    public float getMonto() { return monto; }
    public Date getFechaEmision() { return fechaEmision; }
    public Prestamo getPrestamo() { return prestamo; }
    public boolean isPagada() { return pagada; }
    public Bibliotecario getEmisor() { return emisor; }
}
