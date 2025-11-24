package com.biblioteca.controller;

import com.biblioteca.model.Categoria;
import com.biblioteca.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria item) {
        try {
            Categoria created = service.create(item);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Categoria> get(@PathVariable String nombre) {
        Categoria c = service.findByNombre(nombre);
        if (c != null) {
            return ResponseEntity.ok(c);
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
