package com.biblioteca.controller;

import com.biblioteca.model.Ubicacion;
import com.biblioteca.service.UbicacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacions")
public class UbicacionController {

    private final UbicacionService service;

    public UbicacionController(UbicacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ubicacion> all() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Ubicacion> create(@RequestBody Ubicacion item) {
        Ubicacion created = service.create(item);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{estante}/{seccion}/{columna}/{fila}")
    public ResponseEntity<Ubicacion> get(@PathVariable String estante,
                                         @PathVariable String seccion,
                                         @PathVariable int columna,
                                         @PathVariable int fila) {
        Ubicacion u = service.find(estante, seccion, columna, fila);
        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{estante}/{seccion}/{columna}/{fila}")
    public ResponseEntity<Void> delete(@PathVariable String estante,
                                       @PathVariable String seccion,
                                       @PathVariable int columna,
                                       @PathVariable int fila) {
        boolean removed = service.delete(estante, seccion, columna, fila);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
