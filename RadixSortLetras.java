import java.util.*;

public class RadixSortLetras {
    private Empleo[] theArray;          // ref to array theArray
    private int nElems;               // number of data items
    //-----------------------------------------------------------
    public RadixSortLetras(LinkedList<Empleo> theArray)   {
        this.theArray = new Empleo[theArray.size()];      // create array
        nElems = 0;

		for(int i=0; i<theArray.size(); i++) insert(theArray.get(i));
    }
    
    //-----------------------------------------------------------
    public void insert(Empleo value){
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    public void display() {
        for(int j=0; j<nElems; j++)    // for each element,
            System.out.print(theArray[j].display());  // display it
        System.out.println();
    }

	// A utility function to get maximum value in arr[]
	private int getMax(){
		Empleo mx = theArray[0];
		for (int i = 1; i < nElems; i++)
			if (theArray[i].getJobTitle().length() > mx.getJobTitle().length())
				mx = theArray[i];
		return mx.getJobTitle().length();
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	private void countSort(int exp){
		Empleo[] output = new Empleo[nElems]; // output array
		int i;
		long[] count = new long[256];
		Arrays.fill(count, 0);
		int letraVal;

		// Store count of occurrences in count[]
		for (i = 0; i < nElems; i++){
			if(theArray[i].getJobTitle().length() <= exp) letraVal = 0;
			else letraVal = (int) (theArray[i].getJobTitle().charAt(exp));
			count[letraVal]++;
		}

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 256; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = nElems - 1; i >= 0; i--) {
			if(theArray[i].getJobTitle().length() <= exp) letraVal = 0;
			else letraVal = (int) (theArray[i].getJobTitle().charAt(exp));

			output[(int) (count[letraVal] -1)] = theArray[i];
			count[(int) (letraVal)]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
        theArray = Arrays.copyOf(output, output.length);
		
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public void sort(){
		// Find the maximum number to know number of digits
		int m = getMax();

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = m-1; exp>=0 ;exp--)
			countSort(exp);
	}
}
/* This code is contributed by Devesh Agrawal */
