package com.biblioteca.service;

import com.biblioteca.model.Multa;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MultaService {

    private final List<Multa> data = new ArrayList<>();

    public List<Multa> findAll() {
        return data;
    }

    public Multa create(Multa item) {
        if (item.getUsuario() != null &&
            findByUsuario(item.getUsuario().getNombre()) != null) {
            throw new RuntimeException("Ya existe una multa para ese usuario.");
        }

        // Actualizar estado del usuario
        if (item.getUsuario() != null) {
            item.getUsuario().activarMulta();
        }

        data.add(item);
        return item;
    }

    public Multa findByUsuario(String nombreUsuario) {
        if (nombreUsuario == null) return null;

        return data.stream()
                .filter(x -> x.getUsuario() != null &&
                             nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String nombreUsuario) {
        Optional<Multa> multa = data.stream()
                .filter(x -> x.getUsuario() != null &&
                             nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()))
                .findFirst();

        if (multa.isPresent()) {
            // Limpiar el estado de multa del usuario
            multa.get().getUsuario().limpiarMultas();
        }

        return data.removeIf(x -> x.getUsuario() != null &&
                                  nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()));
    }
}
