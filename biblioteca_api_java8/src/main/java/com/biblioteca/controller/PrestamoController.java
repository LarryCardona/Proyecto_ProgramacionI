package com.biblioteca.controller;

import com.biblioteca.model.Prestamo;
import com.biblioteca.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService service;

    public PrestamoController(PrestamoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prestamo> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Prestamo> create(@RequestBody Prestamo item) {
        try {
            Prestamo created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{nombreUsuario}/{tituloLibro}")
    public ResponseEntity<Prestamo> get(@PathVariable String nombreUsuario,
                                        @PathVariable String tituloLibro) {
        Prestamo p = service.findByUsuarioAndLibro(nombreUsuario, tituloLibro);
        if (p != null) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nombreUsuario}/{tituloLibro}")
    public ResponseEntity<Void> delete(@PathVariable String nombreUsuario,
                                    @PathVariable String tituloLibro) {
        boolean removed = service.delete(nombreUsuario, tituloLibro);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}