package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import mode1.spotify;

public class BinaryInsertionSort {

    public int binarySearchAscendente(spotify a[], spotify item, int low, int high, int subOpcion) {
        if (subOpcion == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getName().compareTo(a[mid].getName()) == 0)
                    return mid + 1;
                else if (item.getName().compareTo(a[mid].getName()) > 0)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getPopularity() == a[mid].getPopularity())
                    return mid + 1;
                else if (item.getPopularity() > a[mid].getPopularity())
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return low;
    }

    public int binarySearchDescendente(spotify a[], spotify item, int low, int high, int subOpcion) {
        if (subOpcion == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getName().compareTo(a[mid].getName()) == 0)
                    return mid + 1;
                else if (item.getName().compareTo(a[mid].getName()) < 0)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getPopularity() == a[mid].getPopularity())
                    return mid + 1;
                else if (item.getPopularity() < a[mid].getPopularity())
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return low;
        
    }

    public spotify[] binaryInsertionSort(spotify a[], int n, int subOpcion, int tipoOrden) {
        int i, loc, j, k;
        spotify selected;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = a[i];

            // encuentra la posicion donde debe ser insertado el elemento
            if (tipoOrden == 1) {
                loc = binarySearchAscendente(a, selected, 0, j, subOpcion);
            } else
                loc = binarySearchDescendente(a, selected, 0, j, subOpcion);

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = selected;
        }
        return a;
    }

 

}
