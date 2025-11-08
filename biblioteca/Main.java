package biblioteca;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA INICIADO ===");

        Permiso permisoPrestamo = new Permiso("Realizar préstamo", true);
        Permiso permisoReserva = new Permiso("Hacer reserva", true);
        Permiso permisoGestion = new Permiso("Gestionar biblioteca", true);


        // -------------------------------
        // 1️⃣ Crear autores
        // -------------------------------
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");


        // -------------------------------
        // 2️⃣ Crear ubicaciones
        // -------------------------------
        Ubicacion ubicacion1 = new Ubicacion("Estante A", "Fila 3", "Posición 5");


        // -------------------------------
        // 3️⃣ Crear usuario
        // -------------------------------
        Usuario usuario1 = new Usuario();
        usuario1.actualizarDatos("María López", "3001234567", "maria@mail.com");
        usuario1.agregarPermiso(permisoPrestamo);
        usuario1.agregarPermiso(permisoReserva);

        // -------------------------------
        // 4️⃣ Crear usuarios
        // -------------------------------
        UsuarioComun usuario1 = new UsuarioComun();
        usuario1.actualizarDatos("Carlos Pérez", "3001112233", "carlos@mail.com", "UsuarioComún");
        usuario1.agregarPermiso(permisoPrestamo);
        usuario1.agregarPermiso(permisoReserva);

        Bibliotecario bibliotecario = new Bibliotecario(
                "Laura Gómez", "laura@mail.com", "3105557788",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );
        bibliotecario.agregarPermiso(permisoGestion);

        // -------------------------------
        // 5️⃣ Crear libros y categorías
        // -------------------------------
        Categoria categoria1 = new Categoria("Programación");
        Libro libro1 = new Libro("Aprende Java", "Juan Torres", categoria1, true);
        Libro libro2 = new Libro("Patrones de Diseño", "Ana Ruiz", categoria1, true);

        bibliotecario.registrarLibro(libro1);
        bibliotecario.registrarLibro(libro2);

        // -------------------------------
        // 6️⃣ Crear préstamo
        // -------------------------------
        Prestamo prestamo1 = new Prestamo(libro1, usuario1, new Date());
        bibliotecario.registrarPrestamo(prestamo1);
        System.out.println("📚 Préstamo creado: " + prestamo1.getLibro().getTitulo());

        // -------------------------------
        // 7️⃣ Crear reserva
        // -------------------------------
        Reserva reserva1 = new Reserva(libro2, usuario1, new Date());
        bibliotecario.agregarReserva(reserva1);
        System.out.println("📘 Reserva registrada para: " + reserva1.getLibro().getTitulo());

        // -------------------------------
        // 8️⃣ Crear multa
        // -------------------------------
        Multa multa1 = new Multa(usuario1, 2000f, new Date(), false);
        multa1.calcularMonto(prestamo1);
        bibliotecario.agregarMulta(multa1);
        System.out.println("💰 Multa creada para " + multa1.getUsuario().getNombre());

        // -------------------------------
        // 9️⃣ Crear notificación
        // -------------------------------
        Notificacion notificacion = new Notificacion(usuario1,
                "Su préstamo está próximo a vencer.", new Date(), false);
        notificacion.enviarNotificacion("Recordatorio de devolución");
        notificacion.marcarLeida();

        System.out.println("📩 Notificación enviada a: " + notificacion.getUsuario().getNombre());

        // -------------------------------
        // 🔟 Mostrar estado general
        // -------------------------------
        System.out.println("\n--- Estado del sistema ---");
        System.out.println("Usuario: " + usuario1.getNombre());
        System.out.println("Permisos: " + usuario1.getPrivilegios().size());
        System.out.println("Libros registrados: " + bibliotecario.getLibros().size());
        System.out.println("Préstamos activos: " + bibliotecario.getPrestamos().size());
        System.out.println("Reservas activas: " + bibliotecario.getReservas().size());
        System.out.println("Multas pendientes: " + bibliotecario.getMultas().size());
        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}
