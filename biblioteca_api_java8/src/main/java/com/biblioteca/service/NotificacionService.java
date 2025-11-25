 package com.biblioteca.service;

import com.biblioteca.model.Notificacion;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NotificacionService {

    private final List<Notificacion> data = new ArrayList<>();

    public List<Notificacion> findAll() {
        return data;
    }

    public Notificacion create(Notificacion item) {
        // Validar duplicado por usuario + mensaje
        if (item.getUsuario() != null &&
            item.getMensaje() != null &&
            findByUsuarioAndMensaje(item.getUsuario().getNombre(), item.getMensaje()) != null) {

            throw new RuntimeException("Ya existe una notificación con ese mensaje para ese usuario.");
        }

        data.add(item);
        return item;
    }

    public Notificacion findByUsuarioAndMensaje(String nombreUsuario, String mensaje) {
        if (nombreUsuario == null || mensaje == null) return null;

        return data.stream()
                .filter(x ->
                        x.getUsuario() != null &&
                        nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()) &&
                        mensaje.equalsIgnoreCase(x.getMensaje())
                )
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String nombreUsuario, String mensaje) {
        return data.removeIf(x ->
                x.getUsuario() != null &&
                nombreUsuario.equalsIgnoreCase(x.getUsuario().getNombre()) &&
                mensaje.equalsIgnoreCase(x.getMensaje())
        );
    }
}
