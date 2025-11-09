package biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Bibliotecario extends Usuario {
    private List<Libro> libros;
    private List<Categoria> categorias;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Reserva> reservas;
    private List<Multa> multas;

    public Bibliotecario(String nombre, String telefono, String email,
                         List<Libro> libros, List<Categoria> categorias,
                         List<Usuario> usuarios, List<Prestamo> prestamos,
                         List<Reserva> reservas, List<Multa> multas,
                         List<Permiso> permisos) {

        super(nombre, telefono, email, "Bibliotecario", permisos != null ? permisos : new ArrayList<Permiso>());
        this.libros = libros != null ? libros : new ArrayList<Libro>();
        this.categorias = categorias != null ? categorias : new ArrayList<Categoria>();
        this.usuarios = usuarios != null ? usuarios : new ArrayList<Usuario>();
        this.prestamos = prestamos != null ? prestamos : new ArrayList<Prestamo>();
        this.reservas = reservas != null ? reservas : new ArrayList<Reserva>();
        this.multas = multas != null ? multas : new ArrayList<Multa>();
    }

    // --- Métodos de gestión ---
    public void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }


    // --- Control de permisos en préstamo y reserva ---
    public void registrarPrestamo(Prestamo prestamo) {
        Usuario usuario = prestamo.getUsuario();

        // Verifica si el usuario puede solicitar prestamo
        if (usuario instanceof UsuarioComun) {
            UsuarioComun uc = (UsuarioComun) usuario;

            boolean tienePermiso = false;
            for (Permiso p : uc.getPrivilegios()) {
                if (p.getNombre().equalsIgnoreCase("SolicitarPrestamo") && p.getEstado()) {
                    tienePermiso = true;
                    break;
                }
            }

            if (!tienePermiso) {
                System.out.println("El usuario tiene multas o prestamos activos. No puede solicitar mas prestamos.");
            }

            uc.incrementarPrestamos();
        }

        prestamos.add(prestamo);
    }

    public void registrarReserva(Reserva reserva) {
        Usuario usuario = reserva.getUsuario();

        if (usuario instanceof UsuarioComun) {
            UsuarioComun uc = (UsuarioComun) usuario;

            boolean tienePermiso = false;
            for (Permiso p : uc.getPrivilegios()) {
                if (p.getNombre().equalsIgnoreCase("SolicitarPrestamo") && p.getEstado()) {
                    tienePermiso = true;
                    break;
                }
            }

            if (!tienePermiso) {
                System.out.println("El usuario tiene multas o prestamos activos. No puede hacer reservas.");
            }
        }

        reservas.add(reserva);
    }

    public void registrarDevolucion(Prestamo prestamo) {
        if (prestamos.remove(prestamo)) {
            Usuario usuario = prestamo.getUsuario();
            if (usuario instanceof UsuarioComun) {
                UsuarioComun uc = (UsuarioComun) usuario;
                uc.disminuirPrestamos();
            }
        }
    }

    public void agregarMulta(Multa multa) {
        multas.add(multa);

        Usuario usuario = multa.getUsuario();
        if (usuario instanceof UsuarioComun) {
            UsuarioComun uc = (UsuarioComun) usuario;
            uc.activarMulta();
        }
    }

    public void eliminarMulta(Multa multa) {
        if (multas.remove(multa)) {
            Usuario usuario = multa.getUsuario();
            if (usuario instanceof UsuarioComun) {
                UsuarioComun uc = (UsuarioComun) usuario;
                uc.limpiarMultas();
            }
        }
    }

    @Override
    public List<Permiso> getPrivilegios() {
        List<Permiso> permisosActivos = new ArrayList<Permiso>();
        for (Permiso permiso : getPermisos()) {
            if (permiso.getEstado()) {
                permisosActivos.add(permiso);
            }
        }
        return permisosActivos;
    }

    // --- Getters ---
    public List<Libro> getLibros() { return libros; }
    public List<Prestamo> getPrestamos() { return prestamos; }
    public List<Reserva> getReservas() { return reservas; }
    public List<Multa> getMultas() { return multas; }
}
