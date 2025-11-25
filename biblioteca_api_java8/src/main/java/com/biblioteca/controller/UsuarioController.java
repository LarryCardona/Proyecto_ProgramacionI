package com.biblioteca.controller;

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario item) {
        Usuario created = service.create(item);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> get(@PathVariable String email) {
        Usuario u = service.findByEmail(email);
        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        boolean removed = service.delete(email);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
