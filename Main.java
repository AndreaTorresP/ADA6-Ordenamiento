import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String archiboEntrada = args[0];
        String archivoSalida = args[1];

        int dato;
        int ordenamiento;
        String tipoDato;
        String tipoOrden;
        Scanner entrada = new Scanner(System.in);
        LinkedList<spotify> listaDatos = new LinkedList<spotify>();

        loadSpotify ls= new loadSpotify(archiboEntrada, archivoSalida);
        listaDatos = ls.readSCV();
      
        
        //Menu
        if(!archivoSalida.contains("Radix")){
            System.out.println("Columna para ordenar:\n1.Name\n2.Popularity");
            dato = entrada.nextInt();
            if(dato == 1){
                tipoDato = "letras";

                System.out.println("Tipo de ordenamiento:\n1.Alfabeticamente\n2.Contrario a alfabeticamente");
                ordenamiento = entrada.nextInt();
            }
            else{
                tipoDato = "numeros";
                
                System.out.println("Tipo de ordenamiento:\n1.Menor a mayor\n2.Mayor a menor");
                ordenamiento = entrada.nextInt();
            }

            if(ordenamiento == 1) tipoOrden = "menor";
            else tipoOrden = "mayor";

            if(archivoSalida.contains("Binary")); /* llamar a binary */
            else if(archivoSalida.contains("Merge")); /* llamar a merge */
            else if(archivoSalida.contains("Quick")){
                QuickSort qck = new QuickSort(tipoDato, tipoOrden, listaDatos);
                qck.recQSort(0, listaDatos.size()-1);
                qck.display();
            }
            else System.out.println("No se especifica el tipo de algoritmo.");
        }
        else{
            System.out.println("Tipo de ordenamiento:\n1.Menor a mayor\n2.Mayor a menor");
            ordenamiento = entrada.nextInt();

            if(ordenamiento == 1) tipoOrden = "menor";
            else tipoOrden = "mayor";

            RadixSort rdx = new RadixSort(tipoOrden, listaDatos);
            rdx.sort();
            rdx.display();
        }

        entrada.close();

        ls.writeCSV(listaDatos);
    }
}
