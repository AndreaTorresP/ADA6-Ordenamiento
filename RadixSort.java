import java.util.*;

public class RadixSort {
	LinkedList<Empleo> theArray;
	private String tipoDato;          // letras o numeros
    private String tipoOrden;         // menor o mayor

	public RadixSort(String tipoDato, String tipoOrden, LinkedList<Empleo> theArray) {
        this.theArray = theArray;
		this.tipoOrden = tipoOrden;
		this.tipoDato = tipoDato;
    }
    
    public void insert(Empleo value){
        theArray.add(value);
    }

    public void display() {
        for(int j=0; j<theArray.size(); j++)
            System.out.print(theArray.get(j).display());
        System.out.println();
    }

	// A utility function to get maximum value in arr[]
	private long getMax(LinkedList<Empleo> array){
		long mx;
		if(tipoDato == "numeros"){
			mx = array.getFirst().getSalary();
			for (int i = 1; i < array.size(); i++){
				if (array.get(i).getSalary() > mx)
					mx = array.get(i).getSalary();
			}
		}
		else{
			mx = Math.abs(array.getFirst().getJobTitle().hashCode());
			for (int i = 1; i < array.size(); i++){
				if (Math.abs(array.get(i).getJobTitle().hashCode()) > mx)
				mx = Math.abs(array.get(i).getJobTitle().hashCode());
			}
		}
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	//Menor a mayor
	private void countSortMenor(int exp){
		Empleo[] output = new Empleo[theArray.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < theArray.size(); i++)
			count[(int) ((theArray.get(i).getSalary() / exp) % 10)]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = theArray.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) ((theArray.get(i).getSalary() / exp) % 10)] - 1)] = theArray.get(i);
			count[(int) ((theArray.get(i).getSalary() / exp) % 10)]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) theArray.add(output[i]);		
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	//Mayor a menor
	private void countSortMayor(int exp){
		Empleo[] output = new Empleo[theArray.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < theArray.size(); i++)
			count[(int) (9 - ((theArray.get(i).getSalary() / exp) % 10))]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = theArray.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) (9 - ((theArray.get(i).getSalary() / exp) % 10))] - 1)] = theArray.get(i);
			count[(int) (9 - ((theArray.get(i).getSalary() / exp) % 10))]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) theArray.add(output[i]);		
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	//Menor a mayor
	private void countSortNegativos(LinkedList<Empleo> array, int exp){
		Empleo[] output = new Empleo[array.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < array.size(); i++){
			int hash = array.get(i).getJobTitle().hashCode();
			int op = (int) (((hash / exp) % 10)+9);
			count[op]++;

			//System.out.println(i);
		}

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = array.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) (((array.get(i).getJobTitle().hashCode() / exp) % 10)+9)] - 1)] = array.get(i);
			count[(int) (((array.get(i).getJobTitle().hashCode() / exp) % 10)+9)]--;
		}

		array.clear();
		for(i = 0; i<output.length; i++) array.add(output[i]);		
	}

	private void countSortPositivos(LinkedList<Empleo> array, int exp){
		Empleo[] output = new Empleo[array.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < array.size(); i++){
			int hash = array.get(i).getJobTitle().hashCode();
			int op = (int) (((hash / exp) % 10));
			count[op]++;

			//System.out.println(i);
		}

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = array.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) ((array.get(i).getJobTitle().hashCode() / exp) % 10)] - 1)] = array.get(i);
			count[(int) ((array.get(i).getJobTitle().hashCode() / exp) % 10)]--;
		}

		array.clear();
		for(i = 0; i<output.length; i++) array.add(output[i]);		
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	//Mayor a menor
	private void countSortCharContraAlf(int exp){
		Empleo[] output = new Empleo[theArray.size()];
		int i;
		long[] count = new long[10];
		Arrays.fill(count, 0);

		for (i = 0; i < theArray.size(); i++)
			count[(int) (9 - ((theArray.get(i).getJobTitle().hashCode() / exp) % 10))]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = theArray.size() - 1; i >= 0; i--) {
			output[(int) (count[(int) (9 - ((theArray.get(i).getJobTitle().hashCode() / exp) % 10))] - 1)] = theArray.get(i);
			count[(int) (9 - ((theArray.get(i).getJobTitle().hashCode() / exp) % 10))]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) theArray.add(output[i]);		
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	public void sort(){
		long m = getMax(theArray);

		if(tipoDato.equals("numeros")){
			if(tipoOrden.equals("menor"))
				for (int exp = 1; m / exp > 0; exp *= 10)
					countSortMenor(exp);
			else
				for (int exp = 1; m / exp > 0; exp *= 10)
					countSortMayor(exp);
		}
		else{
			LinkedList<Empleo> negativos = new LinkedList<>();
			LinkedList<Empleo> positivos = new LinkedList<>();

			for(int i=0; i<theArray.size(); i++){
				if(theArray.get(i).getJobTitle().hashCode()<0)
					negativos.add(theArray.get(i));
				else positivos.add(theArray.get(i));
			}

			m = getMax(negativos);
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSortNegativos(negativos, exp);

			m = getMax(positivos);
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSortPositivos(positivos, exp);

			theArray.clear();
			if(tipoOrden.equals("menor")){
				for(int i=0; i<negativos.size()-1; i++)
					theArray.add(negativos.get(i));
				for(int i=0; i<positivos.size(); i++)
					theArray.add(positivos.get(i));
			}
			else{
				for(int i=positivos.size()-1; i>=0; i--)
					theArray.add(positivos.get(i));
				for(int i=negativos.size()-1; i>=0; i--)
					theArray.add(negativos.get(i));
			}

			//for(int i=0; i<negativos.size(); i++) System.out.println(negativos.get(i).getJobTitle().hashCode());
		}

		for(int i=0; i<theArray.size(); i++) System.out.println(theArray.get(i).getJobTitle().hashCode());
	}
}
