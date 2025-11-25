package com.biblioteca.service;

import com.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {

    private final List<Usuario> data = new ArrayList<>();

    public List<Usuario> findAll() {
        return data;
    }

    public Usuario create(Usuario item) {
        data.add(item);
        return item;
    }

    public Usuario findByEmail(String email) {
        return data.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String email) {
        return data.removeIf(u ->
                u.getEmail().equalsIgnoreCase(email)
        );
    }
}
