package algoritmos;

import java.util.Comparator;
import java.util.LinkedList;

import mode1.spotify;

public class MergeSort {
    private static spotify[] theArray; // ref to array theArray
    private int nElems; // number of data items

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

    public void mergeSort() {
        spotify[] workSpace = new spotify[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    private void recMergeSort(spotify[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) // if range is 1,
            return; // no use sorting
        else {
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound); // sort high half

            if (tipoOrden == "menor")
                partitionMenor(workSpace, lowerBound, mid + 1, upperBound);
            else
                partitionMayor(workSpace, lowerBound, mid + 1, upperBound);

            // merge(workSpace, lowerBound, mid+1, upperBound); // merge them
        } // end else
    } // end recMergeSort()

    private void partitionMenor(spotify[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        if (tipoDato == "numeros") {
            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getPopularity() < theArray[highPtr].getPopularity())
                    workSpace[j++] = theArray[lowPtr++];
                else
                    workSpace[j++] = theArray[highPtr++];

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];

        } else {
            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getName().compareTo(theArray[highPtr].getName()) < 0)
                    workSpace[j++] = theArray[lowPtr++];
                else
                    workSpace[j++] = theArray[highPtr++];

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
        }

    }

    private void partitionMayor(spotify[] workSpace, int lowPtr, int highPtr, int upperBound) {

        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        if (tipoDato == "numeros") {
            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getPopularity() > theArray[highPtr].getPopularity())
                    workSpace[j++] = theArray[lowPtr++];
                else
                    workSpace[j++] = theArray[highPtr++];

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];

        } else {
            while (lowPtr <= mid && highPtr <= upperBound)
                if (theArray[lowPtr].getName().compareTo(theArray[highPtr].getName()) > 0)
                    workSpace[j++] = theArray[lowPtr++];
                else
                    workSpace[j++] = theArray[highPtr++];

            while (lowPtr <= mid)
                workSpace[j++] = theArray[lowPtr++];

            while (highPtr <= upperBound)
                workSpace[j++] = theArray[highPtr++];

            for (j = 0; j < n; j++)
                theArray[lowerBound + j] = workSpace[j];
        }

    }

}
