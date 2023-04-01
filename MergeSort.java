import java.util.LinkedList;
/**
 * La clase MergeSort representa el algoritmo de ordenamiento MergeSort.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/AndreaTorresP/ADA6-Ordenamiento.git>
 */
public class MergeSort{
   LinkedList<Empleo> theArray = new LinkedList<>();
   private String tipoDato;
   private String tipoOrden;
   int[] metricas = new int[2]; // [0] = comparaciones, [1] = intercambios

   /** 
    * Constructor de MergeSort.
    * @param theArray
    * @param tipoDato
    * @param tipoOrden
    */
   public MergeSort(LinkedList<Empleo> theArray, String tipoDato, String tipoOrden)   {
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
         System.out.print(theArray.get(j) + " ");
      System.out.println("");
   }

   /** 
    * Metodo principal del algoritmo de ordenamiento.
    * @return int[]
    */
   public int[] mergeSort() {
      LinkedList<Empleo> workSpace = new LinkedList<>();
      for(int i=0; i<theArray.size(); i++) workSpace.add(null);

      recMergeSort(workSpace, 0, theArray.size()-1);

      return metricas;
   }

   /** 
    * Llama a los metodos para ordenar los datos de la lista, implementa el MergeSort.
    * @param workSpace
    * @param lowerBound
    * @param upperBound
    */
   private void recMergeSort(LinkedList<Empleo> workSpace, int lowerBound, int upperBound){
      if(lowerBound == upperBound)            // if range is 1,
         return;                              // no use sorting
      else {                                    
         int mid = (lowerBound+upperBound) / 2; // find midpoint        
         recMergeSort(workSpace, lowerBound, mid); // sort low half
         recMergeSort(workSpace, mid+1, upperBound); // sort high half
         merge(workSpace, lowerBound, mid+1, upperBound); // merge them
      }
   }

   /** 
    * Mueve los datos de la lista para ordenarlos.
    * @param workSpace
    * @param lowPtr
    * @param highPtr
    * @param upperBound
    */
   private void merge(LinkedList<Empleo> workSpace, int lowPtr, int highPtr, int upperBound) {
      int j = 0;                             // workspace index
      int lowerBound = lowPtr;
      int mid = highPtr-1;
      int n = upperBound-lowerBound+1;       // # of items

      if(tipoDato=="numeros"){
         if(tipoOrden == "menor"){
            while(lowPtr <= mid && highPtr <= upperBound){
               metricas[0]++;
               metricas[1]++;
               if( theArray.get(lowPtr).getSalary() < theArray.get(highPtr).getSalary())
                  workSpace.set(j++, theArray.get(lowPtr++));
               else
                  workSpace.set(j++, theArray.get(highPtr++));
            }
         }
         else{
            while(lowPtr <= mid && highPtr <= upperBound){
               metricas[0]++;
               metricas[1]++;
               if( theArray.get(lowPtr).getSalary() > theArray.get(highPtr).getSalary())
                  workSpace.set(j++, theArray.get(lowPtr++));
               else
                  workSpace.set(j++, theArray.get(highPtr++));
            }
         }
      }
      else{
         if(tipoOrden == "menor"){
            while(lowPtr <= mid && highPtr <= upperBound){
               metricas[0]++;
               metricas[1]++;
               if(theArray.get(lowPtr).getJobTitle().toLowerCase().compareTo(theArray.get(highPtr).getJobTitle().toLowerCase()) < 0)
                  workSpace.set(j++, theArray.get(lowPtr++));
               else
                  workSpace.set(j++, theArray.get(highPtr++));
            }
         }
         else{
            while(lowPtr <= mid && highPtr <= upperBound){
               metricas[0]++;
               metricas[1]++;
               if(theArray.get(lowPtr).getJobTitle().toLowerCase().compareTo(theArray.get(highPtr).getJobTitle().toLowerCase()) > 0)
                  workSpace.set(j++, theArray.get(lowPtr++));
               else
                  workSpace.set(j++, theArray.get(highPtr++));
            }
         }
      }

      while(lowPtr <= mid){
         metricas[1]++;
         workSpace.set(j++, theArray.get(lowPtr++));
      }

      while(highPtr <= upperBound){
         metricas[1]++;
         workSpace.set(j++, theArray.get(highPtr++));
      }

      for(j=0; j<n; j++){
         metricas[1]++;
         theArray.set(lowerBound+j, workSpace.get(j));
      }
   }
}
