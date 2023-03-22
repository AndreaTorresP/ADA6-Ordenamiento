package algoritmos;

import mode1.spotify;

public class QuickSort{
    private spotify[] theArray;       // ref to array theArray
    private int nElems;               // number of data items
    private String tipoDato;          // letras o numeros
    private String tipoOrden;         // menor o mayor

    public QuickSort(int max, String tipoDato, String tipoOrden)   {
      theArray = new spotify[max];
      nElems = 0;
      this.tipoDato = tipoDato;
      this.tipoOrden = tipoOrden;
    }

    public void insert(spotify value){
      theArray[nElems] = value;
      nElems++;
    }

    public void display() {
      for(int j=0; j<nElems; j++)
        System.out.println(theArray[j].display());
      System.out.println("");
    }

    private void swap(int i, int j){
        spotify temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }
    
    //Menor a mayor / Alfabeticamente
    private int partitionMenor(int low, int high){
        spotify pivot = theArray[high];
        int i = (low - 1);
    
        if(tipoDato=="numeros"){
            //Menor a mayor
            for(int j = low; j <= high - 1; j++){
                if (theArray[j].getPopularity() < pivot.getPopularity()){
                    i++;
                    swap(i, j);
                }
            }
        }
        else{
            //Alfabeticamente
            for(int j = low; j <= high - 1; j++){
                if (theArray[j].getName().compareTo(pivot.getName())<0){
                    i++;
                    swap(i, j);
                }
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }

    //Mayor a menor / Contrario a alfabeticamente
    private int partitionMayor(int low, int high){
        spotify pivot = theArray[high];
        int i = (low - 1);
    
        if(tipoDato=="numeros"){
            //Mayor a menor
            for(int j = low; j <= high - 1; j++){
                if (theArray[j].getPopularity() > pivot.getPopularity()){
                    i++;
                    swap(i, j);
                }
            }
        }
        else{
            //Contrario a alfabeticamente
            for(int j = low; j <= high - 1; j++){
                if (theArray[j].getName().compareTo(pivot.getName())>0){
                    i++;
                    swap(i, j);
                }
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }
    
    public void recQSort(int low, int high){
        int pi;
        if (low < high){
            if(tipoOrden == "menor") pi = partitionMenor(low, high);
            else pi = partitionMayor(low, high);

            recQSort(low, pi - 1);
            recQSort(pi + 1, high);
        }
    }
}