import java.util.*;
/**
 * La clase RadixSort representa el algoritmo de ordenamiento RadixSort.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/AndreaTorresP/ADA6-Ordenamiento.git>
 */
public class RadixSort {
	LinkedList<Empleo> theArray;
    private String tipoOrden;     // menor o mayor
	int[] metricas = new int[2];  // [0] = comparaciones, [1] = intercambios

	/** 
    * Constructor de RadixSort.
    * @param tipoOrden
    * @param theArray
    */
	public RadixSort(String tipoOrden, LinkedList<Empleo> theArray) {
        this.theArray = theArray;
		this.tipoOrden = tipoOrden;
		metricas[0] = 0;
      	metricas[1] = 0;
    }

	/** 
     * Imprime el contenido de la lista.
     */
    public void display() {
        for(int j=0; j<theArray.size(); j++)
            System.out.print(theArray.get(j).display());
        System.out.println();
    }

	/** 
	 * Encuentra el valor maximo de la lista.
	 * @param array
	 * @return long
	 */
	private long getMax(LinkedList<Empleo> array){
		Empleo mx = array.getFirst();

		for (int i = 1; i < array.size(); i++){
			metricas[0]++;
			if (array.get(i).getSalary() > mx.getSalary())
				mx = array.get(i);
		}

		return mx.getSalary();
	}

	/** 
	 * Hace un CountingSort ascendente del array de acuerdo al digito representado por exp.
	 * @param exp
	 */
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
			metricas[1]++;
			output[(int) (count[(int) ((theArray.get(i).getSalary() / exp) % 10)] - 1)] = theArray.get(i);
			count[(int) ((theArray.get(i).getSalary() / exp) % 10)]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) {
			metricas[1]++;
			theArray.add(output[i]);
		}
	}

	/** 
	 * Hace un CountingSort descendente del array de acuerdo al digito representado por exp.
	 * @param exp
	 */
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
			metricas[1]++;
			output[(int) (count[(int) (9 - ((theArray.get(i).getSalary() / exp) % 10))] - 1)] = theArray.get(i);
			count[(int) (9 - ((theArray.get(i).getSalary() / exp) % 10))]--;
		}

		theArray.clear();
		for(i = 0; i<output.length; i++) {
			metricas[1]++;
			theArray.add(output[i]);
		}
	}

	/** 
	 * Metodo principal del algoritmo de ordenamiento, implementa el RadixSort.
	 * @return int[]
	 */
	public int[] sort(){
		long m = getMax(theArray);

		if(tipoOrden.equals("menor"))
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSortMenor(exp);
		else
			for (int exp = 1; m / exp > 0; exp *= 10)
				countSortMayor(exp);
		
		return metricas;
	}
}
