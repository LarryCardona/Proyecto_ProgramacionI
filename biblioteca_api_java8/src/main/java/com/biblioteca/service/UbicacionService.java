    package com.biblioteca.service;

    import com.biblioteca.model.Ubicacion;
    import org.springframework.stereotype.Service;
    import java.util.*;

    @Service
    public class UbicacionService {

        private final List<Ubicacion> data = new ArrayList<>();

        public List<Ubicacion> findAll() {
            return data;
        }

        public Ubicacion create(Ubicacion item) {
            data.add(item);
            return item;
        }

        public Ubicacion find(String estante, String seccion, int columna, int fila) {
            return data.stream()
                    .filter(u ->
                            u.getEstante().equalsIgnoreCase(estante) &&
                            u.getSeccion().equalsIgnoreCase(seccion) &&
                            u.getColumna() == columna &&
                            u.getFila() == fila
                    )
                    .findFirst()
                    .orElse(null);
        }

        public boolean delete(String estante, String seccion, int columna, int fila) {
            return data.removeIf(u ->
                    u.getEstante().equalsIgnoreCase(estante) &&
                    u.getSeccion().equalsIgnoreCase(seccion) &&
                    u.getColumna() == columna &&
                    u.getFila() == fila
            );
        }
    }
