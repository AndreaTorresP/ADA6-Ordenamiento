import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
//import java.util.Scanner;
//import java.util.StringTokenizer;

public class loadSpotify {
    String filenameEntrada;
    String filenameSalida;
    File archivo;
    LinkedList<spotify> topSpotify;
    String firstLine = "";

    public loadSpotify(String filenameEntrada, String filenameSalida) {
        this.filenameEntrada = filenameEntrada;
        this.filenameSalida = filenameSalida;
        this.archivo = new File(filenameEntrada);
    }

    public LinkedList<spotify> readSCV() {
        LinkedList<spotify> topSpotify = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filenameEntrada));
            String line = null;
            String[] parts;
            int cont = 0;
            
            while((line = reader.readLine())!=null){
                parts = line.split(",");

                if(cont!=0){
                    //int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String artist = parts[2];
                    String genre = parts[3];
                    int beats = Integer.parseInt(parts[4]);
                    int energy = Integer.parseInt(parts[5]);
                    int danceability = Integer.parseInt(parts[6]);
                    int loudness = Integer.parseInt(parts[7]);
                    int liveness = Integer.parseInt(parts[8]);
                    int valence = Integer.parseInt(parts[9]);
                    int length = Integer.parseInt(parts[10]);
                    int acousticness = Integer.parseInt(parts[11]);
                    int speechiness = Integer.parseInt(parts[12]);
                    int popularity = Integer.parseInt(parts[13]);

                    spotify sp = new spotify(1, name, artist, genre, beats, energy, danceability, loudness,
                    liveness, valence, length, acousticness, speechiness, popularity);
                    topSpotify.add(sp);

                    //System.out.println(sp.display());
                }
                else{
                    firstLine = line;
                    cont = 1;
                }

                reader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return topSpotify;

        /*try (Scanner scan = new Scanner(archivo)) {
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
        }*/
    }

    public void writeCSV(LinkedList<spotify> topSpotify){
        String delimitador = ",";
        String nextLine = "\n";
        String[] parts = firstLine.split(",");

        FileWriter fw;
        try {
            fw = new FileWriter(filenameSalida);

            for(int i=0; i<parts.length-1; i++) fw.append(parts[i]).append(delimitador);
            fw.append(parts[parts.length -1]).append(nextLine);

            //fw.append("Matricula").append(delimitador).append("Asignatura").append(delimitador).append("Calificacion").append(nextLine);

            for(int i=0; i<topSpotify.size(); i++){
                fw.append((i+1) + "").append(delimitador).append(topSpotify.get(i).getName()).append(delimitador)
                .append(topSpotify.get(i).getArtist()).append(delimitador).append(topSpotify.get(i).getGenre()).append(delimitador)
                .append(topSpotify.get(i).getBeats() + "").append(delimitador).append(topSpotify.get(i).getEnergy() + "").append(delimitador)
                .append(topSpotify.get(i).getDanceability() + "").append(delimitador).append(topSpotify.get(i).getLoudness() + "")
                .append(delimitador).append(topSpotify.get(i).getLiveness() + "").append(delimitador).append(topSpotify.get(i).getValence() + "")
                .append(delimitador).append(topSpotify.get(i).getLength() + "").append(delimitador)
                .append(topSpotify.get(i).getAcousticness() + "").append(delimitador).append(topSpotify.get(i).getSpeechiness() + "")
                .append(delimitador).append(topSpotify.get(i).getPopularity() + "").append(nextLine);
            }

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
