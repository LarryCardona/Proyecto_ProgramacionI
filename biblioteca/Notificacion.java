package biblioteca;

import java.util.Date;

public class Notificacion {
    private UsuarioComun usuario;        // Receptor de la notificación
    private Bibliotecario emisor;        // Quien la envía
    private String mensaje;
    private Date fechaEnvio;
    private boolean leida;

    public Notificacion(UsuarioComun usuario, String mensaje, Date fechaEnvio, boolean leida, Bibliotecario emisor) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.leida = leida;
        this.emisor = emisor;
    }

    public void enviarNotificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fechaEnvio = new Date(); // Fecha actual al enviar
        this.leida = false;           // Al enviar, aún no está leída
    }

    public void marcarLeida() {
        this.leida = true;
    }

    public UsuarioComun getUsuario() {
        return usuario;
    }

    public Bibliotecario getEmisor() {
        return emisor;
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
