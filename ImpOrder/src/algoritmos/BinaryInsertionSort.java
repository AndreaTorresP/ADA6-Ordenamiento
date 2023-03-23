package algoritmos;

import java.util.LinkedList;

import mode1.spotify;



public class BinaryInsertionSort {
    
    // implementacion iterativa

    public static <T> int partitionMenor( LinkedList<spotify> topSpotify, spotify item, int low, int high, String tipoDato) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(tipoDato=="numeros"){
                if (item == topSpotify.get(mid))
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        else{
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
            
        }
        return low;
            }

    public static <T> int partitionMayor(LinkedList<spotify> topSpotify, spotify item, int low, int high, String tipoDato) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(tipoDato=="numeros"){
                if (item == topSpotify.get(mid))
                return mid + 1;
            else if (item < a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        else{
            if (item == a[mid])
                return mid + 1;
            else if (item < a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
            
        }
        return low;
    }

    public static <T> LinkedList<spotify> binaryInsertionSort(LinkedList<spotify> topSpotify, int n, String tipoOrden, String tipoDato) {
        
        int i, loc, j, k;
        spotify selected;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = topSpotify.get(i);

            // encuentra la posicion donde debe ser insertado el elemento
            if (tipoOrden == "menor") {
                loc = partitionMenor(topSpotify, selected, 0, j, tipoDato);
            } else
                loc = partitionMayor(topSpotify, selected, 0, j, tipoDato);

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                topSpotify.set(j+1, topSpotify.get(i));
                j--;
            }
            topSpotify.set(j + 1, selected);
        }
        return topSpotify;
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}
