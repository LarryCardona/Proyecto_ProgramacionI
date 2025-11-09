package biblioteca;
import java.util.Date;

public class Reserva {
    private Libro libro;
    private Usuario usuario;
    private Date fechaReserva;
    private boolean activa;
    private Bibliotecario emisor;

    public Reserva(Libro libro, Usuario usuario, Date fechaReserva, Bibliotecario emisor) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaReserva = fechaReserva;
        this.activa = true;
        this.emisor = emisor;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
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
