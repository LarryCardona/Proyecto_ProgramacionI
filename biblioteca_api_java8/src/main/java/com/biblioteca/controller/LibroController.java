package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Libro> create(@RequestBody Libro item) {
        try {
            Libro created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<Libro> get(@PathVariable String titulo) {
        Libro l = service.findByTitulo(titulo);
        if (l != null) {
            return ResponseEntity.ok(l);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{titulo}")
    public ResponseEntity<Void> delete(@PathVariable String titulo) {
        boolean removed = service.delete(titulo);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
