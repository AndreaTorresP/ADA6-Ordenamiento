package menu;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import algoritmos.BinaryInsertionSort;
import algoritmos.MergeSort;
import loadCSV.loadSpotify;
import mode1.spotify;

public class menu {
    loadSpotify ls = new loadSpotify();
    

    public void inicio(String archivoEntrada, String archivoSalida) throws FileNotFoundException {

        
        boolean finalizar = false;
        int opcion;
        int subOpcion;
        int ordenamiento;
        String tipoDato;
        String tipoOrden;
        try (Scanner entrada = new Scanner(System.in)) {

            while (!finalizar) {

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
                        System.out.println("--Haz elegido BinaryInsertionSort--\n");
                        System.out.println("--Desea ordenar por nombre de la cancion o por popularidad--\n");
                        System.out.println("--1: por cancion--\n");
                        System.out.println("--2: popularidad--\n");
                        subOpcion = entrada.nextInt();
                        if (subOpcion == 1) {
                            tipoDato = "letras";
                            System.out.println("--Haz elegido por nombre de la cancion--\n");
                            System.out.println(
                                    "--Deseas ordenar en orden alfabético o en orden inverso al alfabético--\n");
                            System.out.println("--1: por orden--\n");
                            System.out.println("--2: por orden inverso--\n");
                            ordenamiento = entrada.nextInt();
                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                LinkedList<spotify> topSpotify = ls.readSCV(); 
                                topSpotify = BinaryInsertionSort.binaryInsertionSort(topSpotify, topSpotify.size(), tipoDato, tipoOrden);
                            } else
                                tipoOrden = "mayor";// llamada a la funcion binary

                        } else if (subOpcion == 2) {
                            tipoDato = "numeros";
                            System.out.println("--Haz elegido por popularidad--\n");
                            System.out.println("--Deseas ordenar de forma ascendente o descendente--\n");
                            System.out.println("--1: ascendente--\n");
                            System.out.println("--2: por descendente--\n");
                            ordenamiento = entrada.nextInt();

                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                LinkedList<spotify> topSpotify = ls.readSCV(); 
                                topSpotify = MergeSort.mergeSort(topSpotify,  tipoDato, tipoOrden);
                            } else
                                tipoOrden = "mayor";// llamada a la funcion binary

                        }
                        break;

                    case 2:
                        System.out.println("--Haz elegido mergesort--\n");
                        System.out.println("--Desea ordenar por nombre de la cancion o por popularidad--\n");
                        System.out.println("--1: por cancion--\n");
                        System.out.println("--2: popularidad--\n");
                        subOpcion = entrada.nextInt();

                        if (subOpcion == 1) {
                            tipoDato = "letras";
                            System.out.println("--Haz elegido por nombre de la cancion--\n");
                            System.out.println(
                                    "--Deseas ordenar en orden alfabético o en orden inverso al alfabético--\n");
                            System.out.println("--1: por orden--\n");
                            System.out.println("--2: por orden inverso--\n");
                            ordenamiento = entrada.nextInt();
                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                //topSpotify=MergeSort.mergeSort(topSpotify, tipoDato, tipoOrden);

                            } else
                                tipoOrden = "mayor";// llamada a la funcion merge

                        } else if (subOpcion == 2) {
                            tipoDato = "numeros";
                            System.out.println("--Haz elegido por popularidad--\n");
                            System.out.println("--Deseas ordenar de forma ascendente o descendente--\n");
                            System.out.println("--1: ascendente--\n");
                            System.out.println("--2: por descendente--\n");
                            ordenamiento = entrada.nextInt();

                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                // lamada a la funcion merge
                            } else
                                tipoOrden = "mayor";// llamada a la funcion merge

                        }
                        break;

                    case 3:
                        System.out.println("--Haz elegido QuickSort--\n");
                        System.out.println("--Desea ordenar por nombre de la cancion o por popularidad--\n");
                        System.out.println("--1: por cancion--\n");
                        System.out.println("--2: popularidad--\n");
                        subOpcion = entrada.nextInt();

                        if (subOpcion == 1) {
                            tipoDato = "letras";
                            System.out.println("--Haz elegido por nombre de la cancion--\n");
                            System.out.println(
                                    "--Deseas ordenar en orden alfabético o en orden inverso al alfabético--\n");
                            System.out.println("--1: por orden--\n");
                            System.out.println("--2: por orden inverso--\n");
                            ordenamiento = entrada.nextInt();
                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                // lamada a la funcion merge
                            } else
                                tipoOrden = "mayor";// llamada a la funcion merge

                        } else if (subOpcion == 2) {
                            tipoDato = "numeros";
                            System.out.println("--Haz elegido por popularidad--\n");
                            System.out.println("--Deseas ordenar de forma ascendente o descendente--\n");
                            System.out.println("--1: ascendente--\n");
                            System.out.println("--2: por descendente--\n");
                            ordenamiento = entrada.nextInt();

                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                // lamada a la funcion merge
                            } else
                                tipoOrden = "mayor";// llamada a la funcion merge

                        }
                        break;

                    case 4:
                        System.out.println("--Haz elegido radixsort--\n");
                        System.out.println("--Desea ordenar por nombre de la cancion o por popularidad--\n");
                        System.out.println("--1: por cancion--\n");
                        System.out.println("--2: popularidad--\n");
                        subOpcion = entrada.nextInt();

                        if (subOpcion == 1) {
                            tipoDato = "letras";
                            System.out.println("--Haz elegido por nombre de la cancion--\n");
                            System.out.println(
                                    "--Deseas ordenar en orden alfabético o en orden inverso al alfabético--\n");
                            System.out.println("--1: por orden--\n");
                            System.out.println("--2: por orden inverso--\n");
                            ordenamiento = entrada.nextInt();
                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                // lamada a la funcion merge
                            } else
                                tipoOrden = "mayor";// llamada a la funcion merge

                        } else if (subOpcion == 2) {
                            tipoDato = "numeros";
                            System.out.println("--Haz elegido por popularidad--\n");
                            System.out.println("--Deseas ordenar de forma ascendente o descendente--\n");
                            System.out.println("--1: ascendente--\n");
                            System.out.println("--2: por descendente--\n");
                            ordenamiento = entrada.nextInt();

                            if (ordenamiento == 1) {
                                tipoOrden = "menor";
                                // lamada a la funcion merge
                            } else
                                tipoOrden = "mayor";// llamada a la funcion merge

                        }
                        break;
                    case 5:
                        finalizar = true;
                        break;
                    default:
                        System.out.println("Ingrese un valor adecuado");

                }
                System.out.println("¿Desea continuar?");
                System.out.println("1. Si");
                System.out.println("2. No");
                opcion = entrada.nextInt();
                if (opcion == 2) {
                    finalizar = true;
                }
            }
        }
    }
}
