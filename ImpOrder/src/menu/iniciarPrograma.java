package menu;

import java.io.FileNotFoundException;

public class iniciarPrograma {
    public static void main(String[] args) throws FileNotFoundException {
        menu inicio = new menu(); 
        inicio.inicio("top50.csv", "top50Salida.csv");
        
    }   
    
}
