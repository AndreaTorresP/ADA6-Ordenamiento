package loadCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import mode1.spotify;

public class loadSpotify {
    String filename;
    File archivo;
    LinkedList<spotify> topSpotify;

    public loadSpotify(String filename) {
        this.filename = filename;
        this.archivo = new File(filename);
    }

    public LinkedList<spotify> readSCV() throws FileNotFoundException {
        LinkedList<spotify> topSpotify = new LinkedList<>();
        try (Scanner scan = new Scanner(archivo)) {
            StringTokenizer tokenizer;
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

                spotify sp = new spotify(id, name, artist, genre, beats, energy, danceability, loudness, liveness,
                valence, length, acousticness, speechiness, popularity);
                topSpotify.add(sp);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return topSpotify;
    }
}
