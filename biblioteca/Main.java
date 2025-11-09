package biblioteca;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA INICIADO ===");

        // 1. Crear permisos
        Permiso permisoPrestamo = new Permiso("SolicitarPrestamo", true);
        Permiso permisoReserva = new Permiso("HacerReserva", true);
        Permiso permisoGestion = new Permiso("GestionarBiblioteca", true);

        // 2. Crear autor y ubicación
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        Ubicacion ubicacion1 = new Ubicacion("Estante A", "Fila 3", 3, 5);

        // 3. Crear categoría y libros
        Categoria categoria1 = new Categoria(
                "Programación",
                "Libros que enseñan conceptos, técnicas y buenas prácticas de programación en distintos lenguajes y paradigmas."
        );

        Libro libro1 = new Libro(
                "Aprende Java",
                autor1,
                "Editorial Ejemplo",
                2023,
                categoria1,
                ubicacion1,
                true
        );

        Libro libro2 = new Libro(
                "Patrones de Diseño",
                autor1,
                "Editorial Ejemplo",
                2022,
                categoria1,
                ubicacion1,
                true
        );

        // 4. Crear usuario común
        UsuarioComun usuario1 = new UsuarioComun(
                "Carlos Pérez",
                "3001112233",
                "carlos@mail.com",
                true,  // disponible
                0,     // prestamosActivos
                false, // multasActivas
                new ArrayList<>(Arrays.asList(permisoPrestamo, permisoReserva))
        );

        // 5. Crear bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario(
                "Laura Gómez",
                "3105557788",
                "laura@mail.com",
                new ArrayList<>(), // libros
                new ArrayList<>(), // categorias
                new ArrayList<>(), // usuarios
                new ArrayList<>(), // prestamos
                new ArrayList<>(), // reservas
                new ArrayList<>(), // multas
                new ArrayList<>(Arrays.asList(permisoGestion)) // permisos
        );

        // 6. Registrar libros
        bibliotecario.registrarLibro(libro1);
        bibliotecario.registrarLibro(libro2);

        // 7. Registrar préstamo (ajuste: registrarPrestamo devuelve void)
        Calendar calendar = Calendar.getInstance();
        Date fechaPrestamo = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date fechaDevolucion = calendar.getTime();

        Prestamo prestamo1 = new Prestamo(libro1, usuario1, fechaPrestamo, fechaDevolucion, bibliotecario);
        bibliotecario.registrarPrestamo(prestamo1);
        System.out.println("Préstamo creado: " + prestamo1.getLibro().getTitulo());

        // 8. Registrar reserva (ajuste: registrarReserva devuelve void)
        Reserva reserva1 = new Reserva(libro2, usuario1, new Date(), bibliotecario);
        bibliotecario.registrarReserva(reserva1);
        System.out.println("Reserva registrada para: " + reserva1.getLibro().getTitulo());

        // 9. Crear multa
        Multa multa1 = new Multa(usuario1, 0f, new Date(), false, bibliotecario, prestamo1);
        multa1.calcularMonto(prestamo1);
        bibliotecario.agregarMulta(multa1);
        System.out.println("Multa creada para " + multa1.getUsuario().getNombre() +
                " por $" + multa1.getMonto());

        // 10. Crear notificación
        Notificacion notificacion = new Notificacion(
                usuario1,
                "Su préstamo está próximo a vencer.",
                new Date(),
                false
        );
        notificacion.enviarNotificacion("Recordatorio de devolución");
        notificacion.marcarLeida();
        System.out.println("Notificación enviada a: " + notificacion.getUsuario().getNombre());

        // 11. Mostrar estado general
        System.out.println("\n--- Estado del sistema ---");
        System.out.println("Usuario: " + usuario1.getNombre());
        System.out.println("Permisos activos: " + usuario1.getPrivilegios().size());
        System.out.println("Libros registrados: " + bibliotecario.getLibros().size());
        System.out.println("Préstamos activos: " + bibliotecario.getPrestamos().size());
        System.out.println("Reservas activas: " + bibliotecario.getReservas().size());
        System.out.println("Multas pendientes: " + bibliotecario.getMultas().size());

        // === BLOQUE AÑADIDO: Demostración de POLIMORFISMO ===
        System.out.println("\n--- Demostración de Polimorfismo ---");

        // Variables del tipo padre Usuario
        Usuario usuarioComunPoli = usuario1;
        Usuario bibliotecarioPoli = bibliotecario;

        // Lista polimórfica
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioComunPoli);
        usuarios.add(bibliotecarioPoli);

        for (Usuario u : usuarios) {
            System.out.println("Usuario: " + u.getNombre());
            System.out.println("Privilegios: " + u.getPrivilegios());
            System.out.println("----------------------------");
        }

        // Ejemplo de uso polimórfico en préstamo
        Libro libroDemo = new Libro(
                "El Principito",
                new Autor("Antoine de Saint-Exupéry", "Francés"),
                "Reino Infantil",
                1943,
                new Categoria("Fábula", "Obra clásica"),
                new Ubicacion("A1", "Fila 1", 1, 1),
                true
        );

        Date fechaPrestamoDemo = new Date();
        Date fechaDevolucionDemo = new Date(fechaPrestamoDemo.getTime() + 7 * 24 * 60 * 60 * 1000);

        Prestamo prestamoDemo = new Prestamo(libroDemo, usuarioComunPoli, fechaPrestamoDemo, fechaDevolucionDemo, bibliotecario);
        bibliotecario.registrarPrestamo(prestamoDemo); // se usa prestamoDemo correctamente
        System.out.println("Préstamo polimórfico creado por " + usuarioComunPoli.getNombre() +
                " del libro " + prestamoDemo.getLibro().getTitulo());

        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}
