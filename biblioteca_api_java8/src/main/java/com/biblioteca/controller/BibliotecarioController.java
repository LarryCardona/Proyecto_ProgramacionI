package com.biblioteca.controller;

import com.biblioteca.model.Bibliotecario;
import com.biblioteca.service.BibliotecarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecarios")
public class BibliotecarioController {

    private final BibliotecarioService service;

    public BibliotecarioController(BibliotecarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bibliotecario> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Bibliotecario> create(@RequestBody Bibliotecario item) {
        try {
            Bibliotecario created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Bibliotecario> get(@PathVariable String nombre) {
        Bibliotecario b = service.findByNombre(nombre);
        if (b != null) {
            return ResponseEntity.ok(b);
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
