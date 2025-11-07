package biblioteca;

import java.util.List;

public class UsuarioComun {
    private boolean disponible;
    private int prestamosActivos;
    private boolean multasActivas;

    public List<Permiso> getPrivilegios() {
        return null;
    }

    public boolean getDisponibilidad() {
        return disponible;
    }

    public int getPrestamosActivos() {
        return prestamosActivos;
    }

    public boolean getMultasActivas() {
        return multasActivas;
    }
}
