/**
 * La clase Metrica representa los datos de un algoritmo al ser ejecutado.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/AndreaTorresP/ADA6-Ordenamiento.git>
 */
public class Metrica {
    private String algoritmo;
    private int comparaciones;
    private int intercambios;
    private long tiempoEjecucion;
    
    /**
     * Constructor para Metrica.
     * @param algoritmo
     * @param comparaciones
     * @param intercambios
     * @param tiempoEjecucion
     */
    public Metrica(String algoritmo, int comparaciones, int intercambios, long tiempoEjecucion) {
        this.algoritmo = algoritmo;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    /** 
     * Devuelve el algoritmo que se ejecuto.
     * @return String
     */
    public String getAlgoritmo() {
        return algoritmo;
    }
    /** 
     * Establece el algoritmo que se ejecuto.
     * @param algoritmo
     */
    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }
    
    /** 
     * Devuelve la cantidad de comparaciones que hizo el algoritmo.
     * @return int
     */
    public int getComparaciones() {
        return comparaciones;
    }
    /** 
     * Establece la cantidad de comparaciones que hizo el algoritmo.
     * @param comparaciones
     */
    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
    
    /** 
     * Devuelve la cantidad de intercambios que hizo el algoritmo.
     * @return int
     */
    public int getIntercambios() {
        return intercambios;
    }
    /** 
     * Establece la cantidad de intercambios que hizo el algoritmo.
     * @param intercambios
     */
    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }
    
    /** 
     * Devuelve el tiempo de ejecucion del algoritmo.
     * @return long
     */
    public long getTiempoEjecucion() {
        return tiempoEjecucion;
    }
    /** 
     * Establece el tiempo de ejecucion del algoritmo.
     * @param tiempoEjecucion
     */
    public void setTiempoEjecucion(long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    /** 
     * Devuelve los datos de un algoritmo al ser ejecutado.
     * @return String
     */
    @Override
    public String toString() {
        return "Algoritmo: " + getAlgoritmo() + ", Comparaciones: " + getComparaciones() + ", Tntercambios: "
        + getIntercambios() + ", Tiempo de Ejecucion: " + getTiempoEjecucion();
    }
}
