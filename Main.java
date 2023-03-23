import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //String archiboDatos = args[0];
        //String archivoOrden = args[1];

        String archiboDatos = "top50.csv";


        int dato;
        int ordenamiento;
        String tipoDato;
        String tipoOrden;
        Scanner entrada = new Scanner(System.in);
        LinkedList<spotify> listaDatos = new LinkedList<spotify>();

        loadSpotify ls= new loadSpotify(archiboDatos);
        listaDatos = ls.readSCV();
      
        
        //Menu
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


        spotify sp0 = new spotify(3, "jsdj", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        11);
        listaDatos.add(sp0);

        spotify sp1 = new spotify(1, "abc", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        4);
        listaDatos.add(sp1);

        spotify sp2 = new spotify(1, "hdsabc", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        34);
        listaDatos.add(sp2);

        spotify sp3 = new spotify(1, "addcfewbc", "artist", "genre", 112, 11,
        11, 11, 11, 11, 11, 11, 11,
        10);
        listaDatos.add(sp3);

        QuickSort qck = new QuickSort(5, tipoDato, tipoOrden, listaDatos);

        qck.recQSort(0, 3);

        qck.display();
        entrada.close();
    }
}
