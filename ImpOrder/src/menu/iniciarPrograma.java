package menu;

import java.io.FileNotFoundException;

import loadCSV.loadSpotify;

public class iniciarPrograma {
    public static void main(String[] args) throws FileNotFoundException {
        loadSpotify inicio= new loadSpotify();
        inicio.readSCV();
        
    }   
    
}
