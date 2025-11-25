package com.biblioteca.controller;

import com.biblioteca.model.Permiso;
import com.biblioteca.service.PermisoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    private final PermisoService service;

    public PermisoController(PermisoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Permiso> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Permiso> create(@RequestBody Permiso item) {
        try {
            Permiso created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Permiso> get(@PathVariable String nombre) {
        Permiso permiso = service.findByNombre(nombre);
        if (permiso != null) {
            return ResponseEntity.ok(permiso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> delete(@PathVariable String nombre) {
        boolean removed = service.delete(nombre);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
