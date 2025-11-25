package com.biblioteca.controller;

import com.biblioteca.model.Notificacion;
import com.biblioteca.service.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notificacion> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Notificacion> create(@RequestBody Notificacion item) {
        try {
            Notificacion created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{nombreUsuario}/{mensaje}")
    public ResponseEntity<Notificacion> get(@PathVariable String nombreUsuario,
                                            @PathVariable String mensaje) {
        Notificacion n = service.findByUsuarioAndMensaje(nombreUsuario, mensaje);
        if (n != null) {
            return ResponseEntity.ok(n);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nombreUsuario}/{mensaje}")
    public ResponseEntity<Void> delete(@PathVariable String nombreUsuario,
                                    @PathVariable String mensaje) {
        boolean removed = service.delete(nombreUsuario, mensaje);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
