package biblioteca;

import java.util.List;

public class Bibliotecario {
    private String nombre;
    private String email;
    private String telefono;
    private List<Libro> libros;
    private List<Categoria> categorias;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Reserva> reservas;
    private List<Multa> multas;

    public Bibliotecario(String nombre, String email, String telefono,
                         List<Libro> libros, List<Categoria> categorias,
                         List<Usuario> usuarios, List<Prestamo> prestamos,
                         List<Reserva> reservas, List<Multa> multas) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.libros = libros;
        this.categorias = categorias;
        this.usuarios = usuarios;
        this.prestamos = prestamos;
        this.reservas = reservas;
        this.multas = multas;
    }

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

    public void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void registrarDevolucion(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void agregarMulta(Multa multa) {
        multas.add(multa);
    }

    public void eliminarMulta(Multa multa) {
        multas.remove(multa);
    }

    public List<Permiso> getPrivilegios() {
        // No se especifica en el diagrama cómo se obtienen los privilegios.
        // Se deja el método vacío o con retorno nulo.
        return null;
    }
}
