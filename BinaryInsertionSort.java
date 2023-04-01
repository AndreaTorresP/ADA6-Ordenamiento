import java.util.LinkedList;
/**
 * La clase BinaryInsertionSort representa el algoritmo de ordenamiento BinaryInsertion.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/AndreaTorresP/ADA6-Ordenamiento.git>
 */
public class BinaryInsertionSort {
    LinkedList<Empleo> lista = new LinkedList<>();
    int[] metricas = new int[2]; // [0] = comparaciones, [1] = intercambios

    /** 
     * Constructor de BinaryInsertionSort.
     * @param lista
     */
    public BinaryInsertionSort(LinkedList<Empleo> lista) {
        this.lista = lista;
        metricas[0] = 0;
        metricas[1] = 0;
    }

    /** 
     * Encuentra la posicion donde debe ser insertado el elemento en forma ascendente.
     * @param item
     * @param low
     * @param high
     * @param subOpcion
     * @return int
     */
    private int binarySearchAscendente(Empleo item, int low, int high, int subOpcion) {
        if (subOpcion == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) == 0) {
                    metricas[0]++;
                    return mid + 1;
                }
                else if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) > 0) {
                    metricas[0]+=2;
                    low = mid + 1;
                }

                else{
                    high = mid - 1;
                    metricas[0]+=2;
                }
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getSalary() == lista.get(mid).getSalary()) {
                    metricas[0]++;
                    return mid + 1;
                }

                else if (item.getSalary() > lista.get(mid).getSalary()) {
                    metricas[0]+=2;
                    low = mid + 1;
                }

                else{
                    high = mid - 1;
                    metricas[0]+=2;
                }
            }
        }
        return low;
    }

    /** 
     * Encuentra la posicion donde debe ser insertado el elemento en forma descendente.
     * @param item
     * @param low
     * @param high
     * @param subOpcion
     * @return int
     */
    private int binarySearchDescendente(Empleo item, int low, int high, int subOpcion) {

        if (subOpcion == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) == 0) {
                    metricas[0]++;
                    return mid + 1;
                }
                else if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) < 0) {
                    metricas[0]+=2;
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                    metricas[0]+=2;}
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getSalary() == lista.get(mid).getSalary()) {
                    metricas[0]++;
                    return mid + 1;
                }

                else if (item.getSalary() < lista.get(mid).getSalary()) {
                    metricas[0]+=2;
                    low = mid + 1;
                }

                else{
                    high = mid - 1;
                    metricas[0]+=2;
                }
            }
        }
        return low;

    }

    /** 
     * Metodo principal del algoritmo de ordenamiento, ordena los datos de la lista con BinaryInsertionSort.
     * @param n
     * @param subOpcion
     * @param tipoOrden
     * @return int[]
     */
    public int[] binaryInsertionSort(int n, int subOpcion, int tipoOrden) {
        int i, loc, j;
        Empleo selected;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = lista.get(i);

            if (tipoOrden == 1) {
                loc = binarySearchAscendente(selected, 0, j, subOpcion);
            } else
                loc = binarySearchDescendente(selected, 0, j, subOpcion);

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                lista.set(j + 1, lista.get(j));
                metricas[1]++; // Numeros de intercambios
                j--;
            }
            lista.set(j + 1, selected);
            metricas[1]++;
        }

        return metricas;
    }
}
