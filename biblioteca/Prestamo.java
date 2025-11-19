package biblioteca;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private UsuarioComun usuario;   // ← CAMBIO APLICADO
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;
    private Bibliotecario emisor;

    public Prestamo(Libro libro, UsuarioComun usuario, Date fechaPrestamo, Date fechaDevolucion, Bibliotecario emisor) {
        this.libro = libro;
        this.usuario = usuario;   // ← CAMBIO APLICADO
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.emisor = emisor;
    }

    public Libro getLibro() { return libro; }
    public UsuarioComun getUsuario() { return usuario; }  // ← CAMBIO APLICADO
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public Date getFechaDevolucion() { return fechaDevolucion; }
    public boolean isDevuelto() { return devuelto; }
    public Bibliotecario getEmisor() { return emisor; }

    public void setFechaDevolucion(Date nuevaFechaDevolucion) {
        this.fechaDevolucion = nuevaFechaDevolucion;
    }

    public void marcarComoDevuelto() {
        this.devuelto = true;
        libro.actualizarDisponibilidad(true);

        usuario.disminuirPrestamos();  // ← Ya no se necesita instanceof (es siempre UsuarioComun)
    }
}
