package biblioteca;

public class Libro {
    private String titulo;
    private Autor autor;
    private String editorial;
    private int anioPublicacion;
    private Categoria genero;
    private Ubicacion ubicacion;
    private boolean disponible;

    public Libro(String titulo, Autor autor, String editorial, int anioPublicacion,
                 Categoria genero, Ubicacion ubicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
    }

    public void actualizarDisponibilidad(boolean nuevaDisponibilidad) {
        this.disponible = nuevaDisponibilidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Categoria getGenero() {
        return genero;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
