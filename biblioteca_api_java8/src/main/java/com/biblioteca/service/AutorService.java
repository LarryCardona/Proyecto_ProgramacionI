package com.biblioteca.service;

import com.biblioteca.model.Autor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AutorService {

    private final List<Autor> data = new ArrayList<>();

    public List<Autor> findAll() {
        return data;
    }

    public Autor create(Autor item) {
        // Evitar duplicados por nombre
        if (findByNombre(item.getNombre()) != null) {
            throw new RuntimeException("Ya existe un autor con ese nombre.");
        }

        data.add(item);
        return item;
    }

    public Autor findByNombre(String nombre) {
        if (nombre == null) return null;

        return data.stream()
                .filter(x -> nombre.equalsIgnoreCase(x.getNombre()))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String nombre) {
        return data.removeIf(x -> nombre.equalsIgnoreCase(x.getNombre()));
    }
}
