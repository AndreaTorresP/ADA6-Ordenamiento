package menu;

import java.util.Scanner;
import algoritmos.QuickSort;
import mode1.spotify;

public class Main {
    public static void main(String[] args) {
        int dato;
        int ordenamiento;
        String tipoDato;
        String tipoOrden;

        try (Scanner entrada = new Scanner(System.in)) {
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
        }
        
        if(ordenamiento == 1) tipoOrden = "menor";
        else tipoOrden = "mayor";

        QuickSort ord = new QuickSort(5, tipoDato, tipoOrden);

        spotify sp0 = new spotify(3, "jsdj", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        11);
        ord.insert(sp0);

        spotify sp1 = new spotify(1, "abc", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        4);
        ord.insert(sp1);

        spotify sp2 = new spotify(1, "hdsabc", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        34);
        ord.insert(sp2);

        spotify sp3 = new spotify(1, "addcfewbc", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        10);
        ord.insert(sp3);

        ord.recQSort(0, 3);

        ord.display();
    }
}
