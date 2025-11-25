package com.biblioteca.service;

import com.biblioteca.model.Reserva;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    private final List<Reserva> data = new ArrayList<>();

    public List<Reserva> findAll() {
        return data;
    }

    public Reserva create(Reserva item) {
        data.add(item);
        return item;
    }

    public Reserva findByUsuarioYLibro(String nombreUsuario, String tituloLibro) {
        return data.stream()
                .filter(r ->
                        r.getUsuario() != null &&
                        r.getUsuario().getNombre().equalsIgnoreCase(nombreUsuario) &&
                        r.getLibro() != null &&
                        r.getLibro().getTitulo().equalsIgnoreCase(tituloLibro)
                )
                .findFirst()
                .orElse(null);
    }

    public boolean deleteByUsuarioYLibro(String nombreUsuario, String tituloLibro) {
        return data.removeIf(r ->
                r.getUsuario() != null &&
                r.getUsuario().getNombre().equalsIgnoreCase(nombreUsuario) &&
                r.getLibro() != null &&
                r.getLibro().getTitulo().equalsIgnoreCase(tituloLibro)
        );
    }
}
