public class Metrica {
    private String algoritmo;
    private int comparaciones;
    private int intercambios;
    private long tiempoEjecucion;
    
    public Metrica(String algoritmo, int comparaciones, int intercambios, Long tiempoEjecucion) {
        this.algoritmo = algoritmo;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }
    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }
    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }
    public int getComparaciones() {
        return comparaciones;
    }
    public int getIntercambios() {
        return intercambios;
    }
    public long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Algoritmo: " + getAlgoritmo() + ", Comparaciones: " + getComparaciones() + ", Tntercambios: "
        + getIntercambios() + ", Tiempo de Ejecucion: " + getTiempoEjecucion();
    }
}
