package com.biblioteca.controller;

import com.biblioteca.model.Multa;
import com.biblioteca.service.MultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/multas")
public class MultaController {

    private final MultaService service;

    public MultaController(MultaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Multa> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Multa> create(@RequestBody Multa item) {
        try {
            Multa created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{nombreUsuario}")
    public ResponseEntity<Multa> get(@PathVariable String nombreUsuario) {
        Multa multa = service.findByUsuario(nombreUsuario);
        if (multa != null) {
            return ResponseEntity.ok(multa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nombreUsuario}")
    public ResponseEntity<Void> delete(@PathVariable String nombreUsuario) {
        boolean removed = service.delete(nombreUsuario);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
