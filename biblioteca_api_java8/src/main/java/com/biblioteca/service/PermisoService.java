package com.biblioteca.service;

import com.biblioteca.model.Permiso;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PermisoService {

    private final List<Permiso> data = new ArrayList<>();

    public List<Permiso> findAll() {
        return data;
    }

    public Permiso create(Permiso item) {
        // Validar duplicado por nombre
        if (item.getNombre() != null && findByNombre(item.getNombre()) != null) {
            throw new RuntimeException("Ya existe un permiso con ese nombre.");
        }

        data.add(item);
        return item;
    }

    public Permiso findByNombre(String nombre) {
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
