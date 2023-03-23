package menu;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.BinaryOperator;

import algoritmos.BinaryInsertionSort;
import algoritmos.MergeSort;
import loadCSV.loadSpotify;
import mode1.spotify;

public class menu {
    int opcion;
    int subOpcion;
    int tipoOrden;
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
                spotify array[] = cargarArrayBinary();
                bs.binaryInsertionSort(array, lista.size(), subOpcion, tipoOrden);
                break;
            case 2:
                subOpcion = elegirOpcion();
                tipoOrden = modoOrdenar();
                //mergeSort m = new mergeSort(lista.size());

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

    public spotify[] cargarArrayBinary() {
        spotify[] array = new spotify[lista.size()];
        int elements = 0;
        for (int i = 0; i < lista.size(); i++) {
            array[elements] = lista.get(i);
            elements++;
        }
        return array;
    }

}
