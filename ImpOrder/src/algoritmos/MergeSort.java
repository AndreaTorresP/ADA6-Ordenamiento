package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

import mode1.spotify;

public class MergeSort {
    private static spotify[] theArray; // ref to array theArray
    private int nElems; // number of data items
    public static long tiempoTotal = 0;
    public static int numComparaciones = 0;
    public static int numIntercambios = 0;

    public MergeSort(int max) {
        theArray = new spotify[max]; // create array
        nElems = 0;

    }

    public void insert(spotify value) {
        theArray[nElems] = value; // insert it
        nElems++; // increment size

    }

    public void display() {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(theArray[j] + " "); // display it
        System.out.println("");
    }

    public spotify[] mergeSort(LinkedList<spotify> lista, int subOpcion, int tipoOrden) {
        long inicio = System.currentTimeMillis(); // inicio de la ejecución del algoritmo;

        spotify[] workSpace = new spotify[nElems];
        recMergeSort(workSpace, 0, nElems - 1, subOpcion, tipoOrden);

        long fin = System.currentTimeMillis();

        tiempoTotal = fin - inicio;
        return theArray;
    }

    private void recMergeSort(spotify[] workSpace, int lowerBound, int upperBound, int subOpcion,
            int tipoOrden) {
        if (lowerBound == upperBound) // if range is 1,
            return; // no use sorting
        else {
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid, subOpcion, tipoOrden); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound, subOpcion, tipoOrden); // sort high half

            if (tipoOrden == 1)
                partitionMenor(workSpace, lowerBound, mid + 1, upperBound, subOpcion);
            else
                partitionMayor(workSpace, lowerBound, mid + 1, upperBound, subOpcion);

            // merge(workSpace, lowerBound, mid+1, upperBound); // merge them
        } // end else
    } // end recMergeSort()

    private void partitionMenor(spotify[] workSpace, int lowPtr, int highPtr, int upperBound, int subOpcion) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        if (subOpcion == 1) {
            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getName().compareTo(theArray[highPtr].getName()) < 0) {
                    workSpace[j++] = theArray[lowPtr++];
                    numComparaciones++;
                    numIntercambios++;
                }

                else
                    workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];
            numIntercambios++;

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
            numIntercambios++;

        } else {

            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getPopularity() < theArray[highPtr].getPopularity()) {
                    workSpace[j++] = theArray[lowPtr++];
                    numComparaciones++;
                    numIntercambios++;
                }

                else
                    workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];
            numIntercambios++;

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
            numIntercambios++;
        }

    }

    private void partitionMayor(spotify[] workSpace, int lowPtr, int highPtr, int upperBound, int subOpcion) {

        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        if (subOpcion == 1) {
            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getName().compareTo(theArray[highPtr].getName()) > 0) {
                    workSpace[j++] = theArray[lowPtr++];
                    numComparaciones++;
                    numIntercambios++;
                }

                else
                    workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];
            numIntercambios++;

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
            numIntercambios++;

        } else {

            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getPopularity() > theArray[highPtr].getPopularity()) {
                    workSpace[j++] = theArray[lowPtr++];
                    numComparaciones++;
                    numIntercambios++;
                }

                else
                    workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];
            numIntercambios++;

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];
            numIntercambios++;

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
            numIntercambios++;
        }

    }

}
