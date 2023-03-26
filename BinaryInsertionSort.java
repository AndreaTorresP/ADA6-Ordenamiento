import java.util.LinkedList;

public class BinaryInsertionSort {
    LinkedList<Empleo> lista = new LinkedList<>();
    public static long tiempoTotal = 0;
    public static int numComparaciones = 0;
    public static int numIntercambios = 0;

    public BinaryInsertionSort(LinkedList<Empleo> lista) {
        this.lista = lista;
    }

    private int binarySearchAscendente(Empleo item, int low, int high, int subOpcion) {
        if (subOpcion == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) == 0) {
                    numComparaciones++;
                    return mid + 1;
                }

                else if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) > 0) {
                    numComparaciones++;
                    low = mid + 1;
                }

                else
                    high = mid - 1;
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getSalary() == lista.get(mid).getSalary()) {
                    numComparaciones++;
                    return mid + 1;
                }

                else if (item.getSalary() > lista.get(mid).getSalary()) {
                    numComparaciones++;
                    low = mid + 1;
                }

                else
                    high = mid - 1;
            }
        }
        return low;
    }

    private int binarySearchDescendente(Empleo item, int low, int high, int subOpcion) {

        if (subOpcion == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) == 0) {
                    numComparaciones++;
                    return mid + 1;
                }

                else if (item.getJobTitle().toLowerCase().compareTo(lista.get(mid).getJobTitle().toLowerCase()) < 0) {
                    numComparaciones++;
                    low = mid + 1;
                }

                else
                    high = mid - 1;
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; // divide el arreglo en dos
                if (item.getSalary() == lista.get(mid).getSalary()) {
                    numComparaciones++;
                    return mid + 1;
                }

                else if (item.getSalary() < lista.get(mid).getSalary()) {
                    numComparaciones++;
                    low = mid + 1;
                }

                else
                    high = mid - 1;
            }
        }
        return low;

    }

    public void binaryInsertionSort(int n, int subOpcion, int tipoOrden) {
        int i, loc, j;
        Empleo selected;
        long inicio = System.currentTimeMillis(); // Inicio del conteo

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = lista.get(i);

            // encuentra la posicion donde debe ser insertado el elemento
            if (tipoOrden == 1) {
                loc = binarySearchAscendente(selected, 0, j, subOpcion);
            } else
                loc = binarySearchDescendente(selected, 0, j, subOpcion);

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                lista.set(j + 1, lista.get(j));
                numIntercambios++;// Numeros de intercambios
                j--;
            }
            lista.set(j + 1, selected);
        }
        long fin = System.currentTimeMillis(); // fin del cálculo de la ejecución
        tiempoTotal = (fin - inicio); // Total del cálculo de la ejecución del algoritmo
    }
}
