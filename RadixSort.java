import java.util.*;

public class RadixSort {
	LinkedList<spotify> theArray;
	private String tipoOrden;         // menor o mayor

	public RadixSort(String tipoOrden, LinkedList<spotify> theArray) {
        this.theArray = theArray;
		this.tipoOrden = tipoOrden;
    }
    
    public void insert(spotify value){
        theArray.add(value);
    }

    public void display() {
        for(int j=0; j<theArray.size(); j++)
            System.out.print(theArray.get(j).display());
        System.out.println();
    }

	// A utility function to get maximum value in arr[]
	private long getMax(){
		spotify mx = theArray.getFirst();
		for (int i = 1; i < theArray.size(); i++)
			if (theArray.get(i).getPopularity() > mx.getPopularity())
				mx = theArray.get(i);
		return mx.getPopularity();
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	//Menor a mayor
	private void countSortMenor(int exp){
		spotify[] output = new spotify[theArray.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < theArray.size(); i++)
			count[(int) ((theArray.get(i).getPopularity() / exp) % 10)]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = theArray.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) ((theArray.get(i).getPopularity() / exp) % 10)] - 1)] = theArray.get(i);
			count[(int) ((theArray.get(i).getPopularity() / exp) % 10)]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) theArray.add(output[i]);		
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	//Mayor a menor
	private void countSortMayor(int exp){
		spotify[] output = new spotify[theArray.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < theArray.size(); i++)
			count[(int) (9 - ((theArray.get(i).getPopularity() / exp) % 10))]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = theArray.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) (9 - ((theArray.get(i).getPopularity() / exp) % 10))] - 1)] = theArray.get(i);
			count[(int) (9 - ((theArray.get(i).getPopularity() / exp) % 10))]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) theArray.add(output[i]);		
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public void sort(){
		long m = getMax();

		if(tipoOrden.equals("menor"))
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSortMenor(exp);
		else
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSortMayor(exp);
	}
}
