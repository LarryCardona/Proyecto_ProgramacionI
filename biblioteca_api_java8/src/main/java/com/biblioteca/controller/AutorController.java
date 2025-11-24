package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import com.biblioteca.service.AutorService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/autors")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Autor> all() {
        return service.findAll();
    }

    @PostMapping
    public Autor create(@RequestBody Autor item) {
        return service.create(item);
    }

    // 🔥 Buscar autor por su nombre (ya no por id)
    @GetMapping("/{nombre}")
    public Autor get(@PathVariable String nombre) {
        return service.findByNombre(nombre);
    }

    // 🔥 Eliminar autor por su nombre (ya no por id)
    @DeleteMapping("/{nombre}")
    public boolean delete(@PathVariable String nombre) {
        return service.delete(nombre);
    }
}
