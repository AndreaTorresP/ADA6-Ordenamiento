package menu;

import java.util.Scanner;
import loadCSV.loadSpotify;

public class menu {
    //loadSpotify ls= new loadSpotify();

    public void inicio(){
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Columna para ordenar:\n1.Name\n2.Popularity");
            int dato = entrada.nextInt();

            if(dato == 1){
                System.out.println("Tipo de ordenamiento:\n1.Alfabeticamente\n2.Contrario a alfabeticamente");
                int ordenamiento = entrada.nextInt();
            }
            else if(dato == 2){
                System.out.println("Tipo de ordenamiento:\n1.Menor a mayor\n2.Mayor a menor");
                int ordenamiento = entrada.nextInt();
            }
        }
        
    }
}
