package biblioteca;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;
    private Bibliotecario emisor;

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion, Bibliotecario emisor) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.emisor = emisor;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
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

        // ✅ Compatible con Java 8 / 11
        if (usuario instanceof UsuarioComun) {
            UsuarioComun uc = (UsuarioComun) usuario;
            uc.disminuirPrestamos();
        }
    }
}
