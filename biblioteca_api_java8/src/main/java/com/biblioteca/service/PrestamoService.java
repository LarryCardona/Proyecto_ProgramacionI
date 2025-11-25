package com.biblioteca.service;

import com.biblioteca.model.Prestamo;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PrestamoService {

    private final List<Prestamo> data = new ArrayList<>();

    public List<Prestamo> findAll() {
        return data;
    }

    public Prestamo create(Prestamo item) {
        // Validar duplicado por usuario + libro
        if (item.getUsuario() != null &&
            item.getLibro() != null &&
            findByUsuarioAndLibro(item.getUsuario().getNombre(),
                                  item.getLibro().getTitulo()) != null) {

            throw new RuntimeException("Ese usuario ya tiene un préstamo del mismo libro.");
        }

        data.add(item);
        return item;
    }

    public Prestamo findByUsuarioAndLibro(String nombreUsuario, String tituloLibro) {
        if (nombreUsuario == null || tituloLibro == null) return null;

        return data.stream()
                .filter(x ->
                        x.getUsuario() != null &&
                        x.getLibro() != null &&
                        nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()) &&
                        tituloLibro.equalsIgnoreCase(x.getLibro().getTitulo())
                )
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String nombreUsuario, String tituloLibro) {
        return data.removeIf(x ->
                x.getUsuario() != null &&
                x.getLibro() != null &&
                nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()) &&
                tituloLibro.equalsIgnoreCase(x.getLibro().getTitulo())
        );
    }
}
