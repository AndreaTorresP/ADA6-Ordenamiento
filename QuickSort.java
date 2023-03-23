import java.util.LinkedList;

public class QuickSort{
    LinkedList<spotify> theArray;
    private String tipoDato;          // letras o numeros
    private String tipoOrden;         // menor o mayor

    public QuickSort(String tipoDato, String tipoOrden, LinkedList<spotify> theArray)   {
      this.theArray = theArray;
      this.tipoDato = tipoDato;
      this.tipoOrden = tipoOrden;
    }

    public void insert(spotify value){
      theArray.add(value);
    }

    public void display() {
      for(int j=0; j<theArray.size(); j++)
        System.out.println(theArray.get(j).display());
      System.out.println("");
    }

    private void swap(int i, int j){
        spotify tempI = theArray.get(i);
        spotify tempJ = theArray.get(j);

        theArray.add(i, tempJ);
        theArray.remove(i+1);

        theArray.add(j, tempI);
        theArray.remove(j+1);
    }
    
    //Menor a mayor / Alfabeticamente
    private int partitionMenor(int low, int high){
        spotify pivot = theArray.get(high);
        int i = (low - 1);
    
        if(tipoDato=="numeros"){
            //Menor a mayor
            for(int j = low; j <= high - 1; j++){
                if (theArray.get(j).getPopularity() < pivot.getPopularity()){
                    i++;
                    swap(i, j);
                }
            }
        }
        else{
            //Alfabeticamente
            for(int j = low; j <= high - 1; j++){
                if (theArray.get(j).getName().compareTo(pivot.getName())<0){
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
        spotify pivot = theArray.get(high);
        int i = (low - 1);
    
        if(tipoDato=="numeros"){
            //Mayor a menor
            for(int j = low; j <= high - 1; j++){
                if (theArray.get(j).getPopularity() > pivot.getPopularity()){
                    i++;
                    swap(i, j);
                }
            }
        }
        else{
            //Contrario a alfabeticamente
            for(int j = low; j <= high - 1; j++){
                if (theArray.get(j).getName().compareTo(pivot.getName())>0){
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