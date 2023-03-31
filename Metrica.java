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

    
    /** 
     * @param algoritmo
     */
    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }
    
    /** 
     * @param comparaciones
     */
    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
    
    /** 
     * @param intercambios
     */
    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }
    
    /** 
     * @param tiempoEjecucion
     */
    public void setTiempoEjecucion(Long tiempoEjecucion) {
      
      /** 
       * @return String
       */
        this.tiempoEjecucion = tiempoEjecucion;
    }

    
    /** 
     * @return String
     */
    public String getAlgoritmo() {
        return algoritmo;
    }
    
    /** 
     * @return int
     */
    public int getComparaciones() {
        return comparaciones;
    }
    
    /** 
     * @return int
     */
    public int getIntercambios() {
        return intercambios;
    }
    
    /** 
     * @return long
     */
    public long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Algoritmo: " + getAlgoritmo() + ", Comparaciones: " + getComparaciones() + ", Tntercambios: "
        + getIntercambios() + ", Tiempo de Ejecucion: " + getTiempoEjecucion();
    }
}
