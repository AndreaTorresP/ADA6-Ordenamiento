package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import algoritmos.BinaryInsertionSort;
import algoritmos.MergeSort;
import loadCSV.metricas;
import mode1.spotify;

public class menu {
    int opcion;
    int subOpcion;
    int tipoOrden;
    String archivoName;
    metricas m = new metricas();
    private LinkedList<spotify> lista = new LinkedList<>();
    Scanner entrada = new Scanner(System.in);

    public menu(LinkedList<spotify> lista) {
        this.lista = lista;
    }

    public void inicio() {

        System.out.println("--ordenamiento de un programa de top 50 canciones de Spotify--");
        System.out.println("--Bienvenido, elija una opcion:--\n");
        System.out.println("--1: BinaryInsertionSort--\n");
        System.out.println("--2: mergesort--\n");
        System.out.println("--3: QuickSort--\n");
        System.out.println("--4: RadixSort--\n");
        System.out.println("--5: salir--\n");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                subOpcion = elegirOpcion();
                tipoOrden = modoOrdenar();
                BinaryInsertionSort bs = new BinaryInsertionSort();
                spotify array[] = ArrayBinaryInsertionSort();
                array=bs.binaryInsertionSort(array, lista.size(), subOpcion, tipoOrden);
                CSVOrdenado(array, "BinaryInsertionSort.csv");
                try {
                    
                    procedimientos( opcion);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case 2:
                subOpcion = elegirOpcion();
                tipoOrden = modoOrdenar();
                MergeSort m = new MergeSort(lista.size());
                insertMergeSort(m);
                array=m.mergeSort(lista, subOpcion, tipoOrden);
                CSVOrdenado(array, "MergeSort.csv");
                break;

        }        
    }

    public int elegirOpcion() {
        System.out.println("--Desea ordenar por nombre de la cancion o por popularidad--\n");
        System.out.println("1- nombre");
        System.out.println("2- popularidad");
        entrada = new Scanner(System.in);
        int subOpcion = entrada.nextInt();
        return subOpcion;
    }

    public int modoOrdenar() {
        System.out.println("Elige forma de ordenar");
        System.out.println("1- Ascendente");
        System.out.println("2- Descendente");
        entrada = new Scanner(System.in);
        int tipoOrden = entrada.nextInt();
        return tipoOrden;
    }

    public spotify[] ArrayBinaryInsertionSort() {
        spotify[] array = new spotify[lista.size()];
        int elements = 0;
        for (int i = 0; i < lista.size(); i++) {
            array[elements] = lista.get(i);
            elements++;
        }
        return array;
    }

    public void insertMergeSort(MergeSort m) {
        for (int i = 0; i < lista.size(); i++) {
            m.insert(lista.get(i));
        }
    }

    public void CSVOrdenado(spotify [] array, String archivoName){
        try {
            File file = new File(archivoName);
            PrintWriter writer = new PrintWriter(file);
            // Escribir encabezados
            writer.println(" ,Track.Name,Artist.Name,Genre,Beats.Per.Minute,Energy,Danceability,Loudness..dB..,Liveness,Valence.,Length.,Acousticness..,Speechiness.,Popularity");
            // Escribir datos
            for (spotify sp : array) {
                writer.println(sp.getId()+","+sp.getName() + "," + sp.getArtist() + "," + sp.getGenre()+","+
                sp.getBeats()+","+sp.getEnergy()+","+sp.getDanceability()+ ","+sp.getLoudness()+","+ 
                sp.getLiveness() +","+sp.getValence()+ ","+sp.getLength()+","+sp.getAcousticness()+","+
                sp.getSpeechiness()+","+sp.getPopularity());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void procedimientos( int opcion) throws IOException{
        String metricas = "";
        ArrayList<String> listaMetricas = new ArrayList<>();
        listaMetricas.add("Method, EjecutionTime, Comparations, Interchanges");
        
        if(opcion==1){
            metricas =  "BinaryInsertionSort" + "," + BinaryInsertionSort.tiempoTotal + "," + BinaryInsertionSort.numComparaciones + "," + BinaryInsertionSort.numIntercambios;
            listaMetricas.add(metricas);
        }
        else if(opcion==2){
            metricas = "MergeSort" + "," + MergeSort.tiempoTotal + "," + MergeSort.numComparaciones + "," + MergeSort.numIntercambios;
            listaMetricas.add(metricas);
        }
       

        m.escribirArchivoMetricas(listaMetricas);
            
        
    }

}
