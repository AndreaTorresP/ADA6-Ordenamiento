import java.util.LinkedList;

public class QuickSort{
    LinkedList<Empleo> theArray;
    private String tipoDato;         // letras o numeros
    private String tipoOrden;        // menor o mayor
    int[] metricas = new int[2];     // [0] = comparaciones, [1] = intercambios

    public QuickSort(String tipoDato, String tipoOrden, LinkedList<Empleo> theArray){
        this.theArray = theArray;
        this.tipoDato = tipoDato;
        this.tipoOrden = tipoOrden;
        metricas[0] = 0;
        metricas[1] = 0;
    }

    public void insert(Empleo value){
      theArray.add(value);
    }

    public void display() {
      for(int j=0; j<theArray.size(); j++)
        System.out.println(theArray.get(j).display());
      System.out.println("");
    }

    private void swap(int i, int j){
        Empleo tempI = theArray.get(i);
        Empleo tempJ = theArray.get(j);

        theArray.set(i, tempJ);
        theArray.set(j, tempI);

        metricas[1]++;
    }

    //Numeros
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

    //Letras
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
