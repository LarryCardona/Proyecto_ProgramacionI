package com.biblioteca.controller;

import com.biblioteca.model.Reserva;
import com.biblioteca.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reserva> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva item) {
        Reserva created = service.create(item);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{nombreUsuario}/{tituloLibro}")
    public ResponseEntity<Reserva> get(@PathVariable String nombreUsuario,
                                    @PathVariable String tituloLibro) {
        Reserva r = service.findByUsuarioYLibro(nombreUsuario, tituloLibro);
        if (r != null) {
            return ResponseEntity.ok(r);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nombreUsuario}/{tituloLibro}")
    public ResponseEntity<Void> delete(@PathVariable String nombreUsuario,
                                    @PathVariable String tituloLibro) {
        boolean removed = service.deleteByUsuarioYLibro(nombreUsuario, tituloLibro);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
