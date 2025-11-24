package com.biblioteca.model;

import java.util.List;

public abstract class Usuario {
    private String nombre;
    private String telefono;
    private String email;
    private String tipoUsuario;
    private List<Permiso> permisos;

    public Usuario(String nombre, String telefono, String email, String tipoUsuario, List<Permiso> permisos) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.tipoUsuario = tipoUsuario; 
        this.permisos = permisos;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    // 🔹 Getter protegido para uso en subclases
    protected List<Permiso> getPermisos() {
        return permisos;
    }

    public abstract List<Permiso> getPrivilegios();

    public void agregarPermiso(Permiso permiso) {
        if (permiso == null) return;
        if (!permisos.contains(permiso)) {
            permisos.add(permiso);
        }
    }

    public void removerPermiso(Permiso permiso) {
        permisos.remove(permiso);
    }

    public void activarPermiso(String nombrePermiso) {
        for (Permiso p : permisos) {
            if (p.getNombre().equals(nombrePermiso)) {
                p.setEstado(true);
                break;
            }
        }
    }

    public void desactivarPermiso(String nombrePermiso) {
        for (Permiso p : permisos) {
            if (p.getNombre().equals(nombrePermiso)) {
                p.setEstado(false);
                break;
            }
        }
    }
}
