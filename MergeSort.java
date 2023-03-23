import java.util.Comparator;
import java.util.LinkedList;

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

    public static LinkedList<spotify> mergeSort(LinkedList<spotify> topSpotify, Comparator<? super spotify> c) {
        theArray = new spotify[topSpotify.size()];
        theArray = convertirArray(topSpotify);

        spotify[] workSpace = new spotify[topSpotify.size()];
        recMergeSort(workSpace, 0, topSpotify.size() - 1, c);

        topSpotify = convertirLista();

        return topSpotify;
    }

    public static void recMergeSort(spotify[] workSpace, int lowerBound, int upperBound,
            Comparator<? super spotify> c) {
        if (lowerBound == upperBound) // if range is 1,
            return; // no use sorting
        else {
            int mid = (lowerBound + upperBound) / 2; // find midpoint
            recMergeSort(workSpace, lowerBound, mid, c); // sort low half
            recMergeSort(workSpace, mid + 1, upperBound, c); // sort high half
            merge(workSpace, lowerBound, mid + 1, upperBound, c); // merge them
        } // end else
    } // end recMergeSort()

    private static void merge(spotify[] workSpace, int lowPtr, int highPtr, int upperBound,
            Comparator<? super spotify> c) {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // # of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (c.compare(theArray[lowPtr], theArray[highPtr]) < 0)
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

    public static spotify[] convertirArray(LinkedList<spotify> topSpotify) {

        int cont = 0;

        while (cont < topSpotify.size()) {
            theArray[cont] = topSpotify.get(cont);
            cont++;
        }

        return theArray;
    }

    public static LinkedList<spotify> convertirLista() {

        LinkedList<spotify> topSpotify = new LinkedList<>();
        int cont = 0;

        while (cont < theArray.length) {
            topSpotify.add(theArray[cont]);
            cont++;
        }

        return topSpotify;
    }

}
