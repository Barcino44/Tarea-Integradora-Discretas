package model;

import java.io.*;

public class AirLine {
    static String path = "Data/Base de datos de pasajeros.txt";
    public HashTable<String, Passenger> passengers;

    public AirLine() {
        passengers = new HashTable<>();
    }
    public void loadDataBase() throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file); //Lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String[] arr;
        String content = "";
        while ((line = reader.readLine()) != null) {
            arr = line.split("::");
            passengers.insert(
                    arr[0], new Passenger(arr[0], (arr[1])));
            content += line + "\n";
        }
    }
}

