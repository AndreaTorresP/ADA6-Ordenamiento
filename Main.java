import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * La clase Main del programa ejecuta los algoritmos de ordenamiento.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class Main {
    /** 
     * @param args
     */
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

        ArrayList<Metrica> listaMetricas = new ArrayList<>();
        int[] datosMetricas = new int[2];
        long inicioTiempo;
        long finTiempo;
        long tiempoTotal;

        LoadArchivo ls= new LoadArchivo();
        listaDatos = ls.readCSV(archiboEntrada);
        copiarLista(listaDatos, listaCopia);

        //Menu
        System.out.println("Columna para ordenar:\n1.Job Title\n2.Salary\n(RadixSort solo ordena por Salary)");
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


        //BinaryInsertionSort
        BinaryInsertionSort bnr = new BinaryInsertionSort(listaCopia);

        inicioTiempo = System.currentTimeMillis(); // Inicio del conteo
        datosMetricas = bnr.binaryInsertionSort(listaCopia.size(), dato, ordenamiento);
        finTiempo = System.currentTimeMillis(); // fin del cálculo de la ejecución
        tiempoTotal = finTiempo - inicioTiempo; // Total del cálculo de la ejecución del algoritmo

        Metrica unaMetrica = new Metrica("BinaryInsertionSort", datosMetricas[0], datosMetricas[1], tiempoTotal);
        listaMetricas.add(unaMetrica);

        ls.writeCSV(listaCopia, direccion + "BinaryInsertionSort_ordenado.csv");


        //MergeSort
        copiarLista(listaDatos, listaCopia);
        MergeSort mrg = new MergeSort(listaCopia, tipoDato, tipoOrden);

        inicioTiempo = System.currentTimeMillis(); // Inicio del conteo
        datosMetricas = mrg.mergeSort();
        finTiempo = System.currentTimeMillis(); // fin del cálculo de la ejecución
        tiempoTotal = finTiempo - inicioTiempo; // Total del cálculo de la ejecución del algoritmo

        unaMetrica = new Metrica("MergeSort", datosMetricas[0], datosMetricas[1], tiempoTotal);
        listaMetricas.add(unaMetrica);

        ls.writeCSV(listaCopia, direccion + "MergeSort_ordenado.csv");


        //Quicksort
        copiarLista(listaDatos, listaCopia);
        QuickSort qck = new QuickSort(tipoDato, tipoOrden, listaCopia);

        inicioTiempo = System.currentTimeMillis(); // Inicio del conteo
        datosMetricas = qck.recQSort(0, listaDatos.size()-1);
        finTiempo = System.currentTimeMillis(); // fin del cálculo de la ejecución
        tiempoTotal = finTiempo - inicioTiempo; // Total del cálculo de la ejecución del algoritmo

        unaMetrica = new Metrica("QuickSort", datosMetricas[0], datosMetricas[1], tiempoTotal);
        listaMetricas.add(unaMetrica);

        ls.writeCSV(listaCopia, direccion + "QuickSort_ordenado.csv");


        //Radixsort
        copiarLista(listaDatos, listaCopia);
        RadixSort rdx = new RadixSort(tipoOrden, listaCopia);

        inicioTiempo = System.currentTimeMillis(); // Inicio del conteo
        datosMetricas = rdx.sort();
        finTiempo = System.currentTimeMillis(); // fin del cálculo de la ejecución
        tiempoTotal = finTiempo - inicioTiempo; // Total del cálculo de la ejecución del algoritmo

        unaMetrica = new Metrica("RadixSort", datosMetricas[0], datosMetricas[1], tiempoTotal);
        listaMetricas.add(unaMetrica);

        ls.writeCSV(listaCopia, direccion + "RadixSort_ordenado.csv");


        ls.metricasCSV(listaMetricas, direccion);
        entrada.close();
    }

    /** 
     * Copia una lista ligada en otra.
     * @param listaOriginal
     * @param listaCopia
     */
    public static void copiarLista(LinkedList<Empleo> listaOriginal, LinkedList<Empleo> listaCopia){
        listaCopia.clear();
        for(int i=0; i<listaOriginal.size(); i++) listaCopia.add(listaOriginal.get(i));
    }
}
