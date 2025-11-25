package com.biblioteca.controller;

import com.biblioteca.model.UsuarioComun;
import com.biblioteca.service.UsuarioComunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuariocomuns")
public class UsuarioComunController {

    private final UsuarioComunService service;

    public UsuarioComunController(UsuarioComunService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioComun> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<UsuarioComun> create(@RequestBody UsuarioComun item) {
        UsuarioComun created = service.create(item);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioComun> get(@PathVariable String email) {
        UsuarioComun u = service.findByEmail(email);
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
