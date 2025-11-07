package biblioteca;
import java.util.Date;

public class Notificacion {
    private Usuario usuario;
    private String mensaje;
    private Date fechaEnvio;
    private boolean leida;

    public Notificacion(Usuario usuario, String mensaje, Date fechaEnvio, boolean leida) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.leida = leida;
    }

    public void enviarNotificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fechaEnvio = new Date(); // Fecha actual al enviar
        this.leida = false;
    }

    public void marcarLeida() {
        this.leida = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public boolean isLeida() {
        return leida;
    }
}

