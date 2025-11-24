package com.biblioteca.service;

import com.biblioteca.model.Categoria;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoriaService {

    private final List<Categoria> data = new ArrayList<>();

    public List<Categoria> findAll() {
        return data;
    }

    public Categoria create(Categoria item) {
        // Validar duplicado por nombre
        if (findByNombre(item.getNombre()) != null) {
            throw new RuntimeException("Ya existe una categoría con ese nombre.");
        }

        data.add(item);
        return item;
    }

    public Categoria findByNombre(String nombre) {
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
