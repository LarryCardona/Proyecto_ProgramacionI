package com.biblioteca.service;

import com.biblioteca.model.Bibliotecario;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BibliotecarioService {

    private final List<Bibliotecario> data = new ArrayList<>();

    public List<Bibliotecario> findAll() {
        return data;
    }

    public Bibliotecario create(Bibliotecario item) {
        // Validar que no exista otro con el mismo nombre
        if (findByNombre(item.getNombre()) != null) {
            throw new RuntimeException("Ya existe un bibliotecario con ese nombre.");
        }

        data.add(item);
        return item;
    }

    public Bibliotecario findByNombre(String nombre) {
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
