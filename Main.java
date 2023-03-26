import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String direccion = "CSV/";
        String archiboEntrada = direccion + "Salary-Data.csv";
        int dato;
        int ordenamiento;
        String tipoDato;
        String tipoOrden;
        Scanner entrada = new Scanner(System.in);
        LinkedList<Empleo> listaDatos = new LinkedList<Empleo>();
        LinkedList<Empleo> listaCopia = new LinkedList<Empleo>();

        LoadArchivo ls= new LoadArchivo();
        listaDatos = ls.readSCV(archiboEntrada);
        copiarLista(listaDatos, listaCopia);

        //Menu
        System.out.println("Columna para ordenar:\n1.Job Title\n2.Salary");
        dato = entrada.nextInt();
        if(dato == 1){
            tipoDato = "letras";

            System.out.println("Tipo de ordenamiento:\n1.Alfabeticamente\n2.Contrario a alfabeticamente");
            ordenamiento = entrada.nextInt();
        }
        else{
            tipoDato = "numeros";
            
            System.out.println("Tipo de ordenamiento:\n1.Menor a mayor\n2.Mayor a menor");
            ordenamiento = entrada.nextInt();
        }

        if(ordenamiento == 1) tipoOrden = "menor";
        else tipoOrden = "mayor";

        // llamar a binary
        BinaryInsertionSort bnr = new BinaryInsertionSort(listaCopia);
        bnr.binaryInsertionSort(listaCopia.size(), dato, ordenamiento);
        ls.writeCSV(listaCopia, direccion + "BinaryInsertionSort_ordenado.csv");

        // llamar a merge
        copiarLista(listaDatos, listaCopia);
        MergeSort mrg = new MergeSort(listaCopia, tipoDato, tipoOrden);
        mrg.mergeSort();
        ls.writeCSV(listaCopia, direccion + "MergeSort_ordenado.csv");

        //Quicksort
        copiarLista(listaDatos, listaCopia);
        QuickSort qck = new QuickSort(tipoDato, tipoOrden, listaCopia);
        qck.recQSort(0, listaDatos.size()-1);
        ls.writeCSV(listaCopia, direccion + "QuickSort_ordenado.csv");

        //Radixsort
        copiarLista(listaDatos, listaCopia);
        RadixSort rdx = new RadixSort(tipoDato, tipoOrden, listaCopia);
        rdx.sort();
        ls.writeCSV(listaCopia, direccion + "RadixSort_ordenado.csv");

        //for(int i=0; i<listaDatos.size(); i++) System.out.println(listaDatos.get(i).display());
    
        entrada.close();
    }

    public static void copiarLista(LinkedList<Empleo> listaOriginal, LinkedList<Empleo> listaCopia){
        listaCopia.clear();
        for(int i=0; i<listaOriginal.size(); i++) listaCopia.add(listaOriginal.get(i));
    }
}
