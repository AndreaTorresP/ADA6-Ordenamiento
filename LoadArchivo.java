import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class LoadArchivo {
    LinkedList<Empleo> listaEmpleos = new LinkedList<Empleo>();
    String firstLine;

    public LoadArchivo() {
        this.firstLine = "";
    }

    
    /** 
     * @param filenameEntrada
     * @return LinkedList<Empleo>
     */
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

    public void metricasCSV(ArrayList<Metrica> listaMetricas, String direccion){
        File archivo;
        String path = direccion + "Metricas.csv";
        String delimitador = ",";
        String nextLine = "\n";
        
        archivo = new File(path);
        
        try{
            FileWriter fw = new FileWriter(archivo);

            fw.append("Algoritmo").append(delimitador).append("Tiempo de ejecucion (ms)").append(delimitador)
            .append("Comparaciones").append(delimitador).append("Intercambios").append(nextLine);
            
            for(int i = 0; i < listaMetricas.size(); i++ ) {
                fw.append(listaMetricas.get(i).getAlgoritmo()).append(delimitador)
                .append(listaMetricas.get(i).getTiempoEjecucion() + "").append(delimitador)
                .append(listaMetricas.get(i).getComparaciones() + "").append(delimitador)
                .append(listaMetricas.get(i).getIntercambios() + "").append(nextLine);
            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
