import java.util.LinkedList;
/**
 * La clase QuickSort representa el algoritmo de ordenamiento QuickSort.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/AndreaTorresP/ADA6-Ordenamiento.git>
 */
public class QuickSort{
    LinkedList<Empleo> theArray;
    private String tipoDato;         // letras o numeros
    private String tipoOrden;        // menor o mayor
    int[] metricas = new int[2];     // [0] = comparaciones, [1] = intercambios

    /** 
    * Constructor de QuickSort.
    * @param tipoDato
    * @param tipoOrden
    * @param theArray
    */
    public QuickSort(String tipoDato, String tipoOrden, LinkedList<Empleo> theArray){
        this.theArray = theArray;
        this.tipoDato = tipoDato;
        this.tipoOrden = tipoOrden;
        metricas[0] = 0;
        metricas[1] = 0;
    }

    /** 
     * Imprime el contenido de la lista.
     */
    public void display() {
      for(int j=0; j<theArray.size(); j++)
        System.out.println(theArray.get(j).display());
      System.out.println("");
    }

    /** 
     * Intercambia el dato i de la lista con el dato j.
     * @param i
     * @param j
     */
    private void swap(int i, int j){
        Empleo tempI = theArray.get(i);
        Empleo tempJ = theArray.get(j);

        theArray.set(i, tempJ);
        theArray.set(j, tempI);

        metricas[1]++;
    }

    /** 
     * Coloca el ultimo elemento como pivote y lo coloca en su posicion correcta ordenado por el salario del
     * trabajo; dependiendo de la opcion, coloca los valores menores a su izquierda y los mayores a su derecha o
     * viceversa.
     * @param low
     * @param high
     * @return int
     */
    private int partitionNums(int low, int high){
        Empleo pivot = theArray.get(high);
        int i = (low - 1);
    
        if(tipoOrden=="menor"){
            //Menor a mayor
            for(int j = low; j <= high - 1; j++){
                metricas[0]++;
                if (theArray.get(j).getSalary() < pivot.getSalary()){
                    i++;
                    swap(i, j);
                }
            }
        }
        else{
            //Mayor a menor
            for(int j = low; j <= high - 1; j++){
                metricas[0]++;
                if (theArray.get(j).getSalary() > pivot.getSalary()){
                    i++;
                    swap(i, j);
                }
            }
        }

        swap(i + 1, high);

        return (i + 1);
    }

    /** 
     * Coloca el ultimo elemento como pivote y lo coloca en su posicion correcta ordenado por el nombre del trabajo;
     * dependiendo de la opcion, coloca los valores menores a su izquierda y los mayores a su derecha o viceversa.
     * @param low
     * @param high
     * @return int
     */
    private int partitionChars(int low, int high){
        String pivot = theArray.get(high).getJobTitle().toLowerCase();
        int i = (low - 1);
    
        if(tipoOrden=="menor"){
            //Alfabeticamente
            for(int j = low; j <= high - 1; j++){
                metricas[0]++;
                if (theArray.get(j).getJobTitle().toLowerCase().compareTo(pivot)<0){
                    i++;
                    swap(i, j);
                }
            }
        }
        else{
            //Contrario a alfabeticamente
            for(int j = low; j <= high - 1; j++){
                metricas[0]++;
                if (theArray.get(j).getJobTitle().toLowerCase().compareTo(pivot)>0){
                    i++;
                    swap(i, j);
                }
            }
        }

        swap(i + 1, high);

        return (i + 1);
    }
    
    /** 
     * Metodo principal del algoritmo de ordenamiento, implementa el QuickSort.
     * @param low
     * @param high
     * @return int[]
     */
    public int[] recQSort(int low, int high){
        int pi;

        if (low < high){
            if(tipoDato == "numeros")pi = partitionNums(low, high);
            else pi = partitionChars(low, high);

            recQSort(low, pi - 1);
            recQSort(pi + 1, high);
        }

        return metricas;
    }
}
