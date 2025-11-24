package com.biblioteca.model;

import java.util.List;
import java.util.ArrayList;

public class UsuarioComun extends Usuario {
    private boolean disponible;
    private int prestamosActivos;
    private boolean multasActivas;

    public UsuarioComun(String nombre, String telefono, String email,
                        boolean disponible, int prestamosActivos,
                        boolean multasActivas, List<Permiso> permisos) {
        super(nombre, telefono, email, "UsuarioComun", permisos != null ? permisos : new ArrayList<>());
        this.disponible = disponible;
        this.prestamosActivos = prestamosActivos;
        this.multasActivas = multasActivas;
    }

    @Override
    public List<Permiso> getPrivilegios() {
        // Si el usuario tiene multas o préstamos activos, se desactiva el permiso de solicitar préstamo
        for (Permiso permiso : getPermisos()) {
            if (permiso.getNombre().equalsIgnoreCase("SolicitarPrestamo")) {
                permiso.setEstado(!(multasActivas || prestamosActivos > 0));
            }
        }

        // Retornar solo los permisos activos
        List<Permiso> permisosActivos = new ArrayList<>();
        for (Permiso permiso : getPermisos()) {
            if (permiso.getEstado()) {
                permisosActivos.add(permiso);
            }
        }
        return permisosActivos;
    }

    // --- Getters ---
    public boolean getDisponibilidad() {
        return disponible;
    }

    public int getPrestamosActivos() {
        return prestamosActivos;
    }

    public boolean getMultasActivas() {
        return multasActivas;
    }

    // --- Actualizaciones automáticas desde Prestamo o Multa ---
    public void incrementarPrestamos() {
        this.prestamosActivos++;
    }

    public void disminuirPrestamos() {
        if (this.prestamosActivos > 0) this.prestamosActivos--;
    }

    public void activarMulta() {
        this.multasActivas = true;
    }

    public void limpiarMultas() {
        this.multasActivas = false;
    }
}
