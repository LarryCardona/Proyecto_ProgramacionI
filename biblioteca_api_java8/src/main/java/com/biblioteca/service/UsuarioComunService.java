package com.biblioteca.service;

import com.biblioteca.model.UsuarioComun;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioComunService {

    private final List<UsuarioComun> data = new ArrayList<>();

    public List<UsuarioComun> findAll() {
        return data;
    }

    public UsuarioComun create(UsuarioComun item) {
        data.add(item);
        return item;
    }

    public UsuarioComun findByEmail(String email) {
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
