package biblioteca;

import java.util.List;

public abstract class Usuario {
    private String nombre;
    private String telefono;
    private String email;
    private String tipoUsuario;
    private List<Permiso> permisos;

    public Usuario(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public void actualizarDatos(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public abstract List<Permiso> getPrivilegios();

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void agregarPermiso(Permiso permiso) {
        // implementación vacía según UML
    }

    public void removerPermiso(Permiso permiso) {
        // implementación vacía según UML
    }

    public void activarPermiso(String nombrePermiso) {
        // implementación vacía según UML
    }

    public void desactivarPermiso(String nombrePermiso) {
        // implementación vacía según UML
    }
}
