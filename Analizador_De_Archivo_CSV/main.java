import java.io.*;
import java.util.*;

public class AnalizadorCSV {

    public static void analizarCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            int numLineas = 0;
            while ((line = br.readLine()) != null) {
                numLineas++;
                String[] valores = line.split(",");
                System.out.println("Línea " + numLineas + ": " + Arrays.toString(valores));
            }
            System.out.println("Total de líneas: " + numLineas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String archivoCSV = "datos.csv";
        analizarCSV(archivoCSV);
    }
}
