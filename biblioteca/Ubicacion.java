package biblioteca;

public class Ubicacion {
    private String estante;
    private String seccion;
    private int columna;
    private int fila;

    public Ubicacion(String estante, String seccion, int columna, int fila) {
        this.estante = estante;
        this.seccion = seccion;
        this.columna = columna;
        this.fila = fila;
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

    public boolean actualizarUbicacion(String nuevoEstante, String nuevaSeccion, int nuevaColumna, int nuevaFila) {
        if (nuevoEstante != null && nuevaSeccion != null && nuevaColumna >= 0 && nuevaFila >= 0) {
            this.estante = nuevoEstante;
            this.seccion = nuevaSeccion;
            this.fila = nuevaFila;
            this.columna = nuevaColumna;
            return true;
        }
        return false;
    }
}
