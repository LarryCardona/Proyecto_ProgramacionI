package com.biblioteca.service;

import com.biblioteca.model.Libro;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LibroService {

    private final List<Libro> data = new ArrayList<>();

    public List<Libro> findAll() {
        return data;
    }

    public Libro create(Libro item) {
        // Validar duplicado por título
        if (findByTitulo(item.getTitulo()) != null) {
            throw new RuntimeException("Ya existe un libro con ese título.");
        }

        data.add(item);
        return item;
    }

    public Libro findByTitulo(String titulo) {
        if (titulo == null) return null;

        return data.stream()
                .filter(x -> titulo.equalsIgnoreCase(x.getTitulo()))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String titulo) {
        return data.removeIf(x -> titulo.equalsIgnoreCase(x.getTitulo()));
    }
}
