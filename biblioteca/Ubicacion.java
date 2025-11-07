package biblioteca;

public class Ubicacion {
    private String estante;
    private String seccion;
    private int columna;
    private int fila;

    public Ubicacion(String estante, String seccion) {
        this.estante = estante;
        this.seccion = seccion;
        this.columna = 0;
        this.fila = 0;
    }

    public String getEstante() {
        return estante;
    }

    public String getSeccion() {
        return seccion;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean actualizarUbicacion(String nuevoEstante, String nuevaSeccion) {
        if (nuevoEstante != null && nuevaSeccion != null) {
            this.estante = nuevoEstante;
            this.seccion = nuevaSeccion;
            return true;
        }
        return false;
    }
}
