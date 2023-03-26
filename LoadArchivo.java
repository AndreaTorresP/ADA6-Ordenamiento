import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
//import java.util.Scanner;
//import java.util.StringTokenizer;

public class LoadArchivo {
    LinkedList<Empleo> listaEmpleos = new LinkedList<Empleo>();
    String firstLine;

    public LoadArchivo() {
        this.firstLine = "";
    }

    public LinkedList<Empleo> readSCV(String filenameEntrada) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filenameEntrada));
            String line = null;
            String[] parts;
            int cont = 0;
            
            while((line = reader.readLine())!=null){
                parts = line.split(",");

                if(cont!=0){
                    int age = Integer.parseInt(parts[0]);
                    String gender = parts[1];
                    String educationLevel = parts[2];
                    String jobTitle = parts[3];
                    double yearsExperience = Double.parseDouble(parts[4]);
                    int salary = Integer.parseInt(parts[5]);

                    Empleo sp = new Empleo(age, gender, educationLevel, jobTitle, yearsExperience, salary);
                    listaEmpleos.add(sp);
                }
                else{
                    firstLine = line;
                    cont = 1;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaEmpleos;

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

    public void writeCSV(LinkedList<Empleo> listaOrdenada, String filenameSalida){
        String delimitador = ",";
        String nextLine = "\n";
        String[] parts = firstLine.split(",");

        FileWriter fw;
        try {
            fw = new FileWriter(filenameSalida);

            for(int i=0; i<parts.length-1; i++) fw.append(parts[i]).append(delimitador);
            fw.append(parts[parts.length -1]).append(nextLine);

            for(int i=0; i<listaOrdenada.size(); i++){
                fw.append(listaOrdenada.get(i).getAge() + "").append(delimitador)
                .append(listaOrdenada.get(i).getGender()).append(delimitador)
                .append(listaOrdenada.get(i).getEducationLevel()).append(delimitador)
                .append(listaOrdenada.get(i).getJobTitle() + "").append(delimitador)
                .append(listaOrdenada.get(i).getYearsExperience() + "").append(delimitador)
                .append(listaOrdenada.get(i).getSalary() + "").append(nextLine);
            }

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
