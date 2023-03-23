package loadCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import menu.menu;
import mode1.spotify;

public class loadSpotify {


    public LinkedList <spotify> readSCV() throws FileNotFoundException {
        LinkedList<spotify> lista = new LinkedList<>();
        String filename = "top50.csv";
        

        try {
        File archivo = new File(filename);
        Scanner scan = new Scanner(new FileReader(archivo));
        StringTokenizer tokenizer;
        if(scan.hasNext()){
            scan.nextLine();
        }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                tokenizer = new StringTokenizer(line, ",");
                int id = Integer.parseInt(tokenizer.nextToken());
                String name = tokenizer.nextToken();
                String artist = tokenizer.nextToken();
                String genre = tokenizer.nextToken();
                int beats = Integer.parseInt(tokenizer.nextToken());
                int energy = Integer.parseInt(tokenizer.nextToken());
                int danceability = Integer.parseInt(tokenizer.nextToken());
                int loudness = Integer.parseInt(tokenizer.nextToken());
                int liveness = Integer.parseInt(tokenizer.nextToken());
                int valence = Integer.parseInt(tokenizer.nextToken());
                int length = Integer.parseInt(tokenizer.nextToken());
                int acousticness = Integer.parseInt(tokenizer.nextToken());
                int speechiness = Integer.parseInt(tokenizer.nextToken());
                int popularity = Integer.parseInt(tokenizer.nextToken());

                spotify sp= new spotify(id, name, artist, genre, beats, energy, danceability, loudness, liveness, valence, length, acousticness, speechiness, popularity);
                lista.add(sp);

            }
            scan.close();

            menu menu = new menu(lista);
            menu.inicio();

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;

    }

}
