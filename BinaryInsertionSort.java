import java.util.LinkedList;

public class BinaryInsertionSort {
    LinkedList<Empleo> lista = new LinkedList<>();
    int[] metricas = new int[2]; // [0] = comparaciones, [1] = intercambios

    public BinaryInsertionSort(LinkedList<Empleo> lista) {
        this.lista = lista;
        metricas[0] = 0;
        metricas[1] = 0;
    }

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

    public int[] binaryInsertionSort(int n, int subOpcion, int tipoOrden) {
        int i, loc, j;
        Empleo selected;

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
                metricas[1]++; // Numeros de intercambios
                j--;
            }
            lista.set(j + 1, selected);
            metricas[1]++;
        }

        return metricas;
    }
}
