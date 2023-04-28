package model;

import java.io.*;

public class AirLine {
    static String path = "Data/Base de datos de pasajeros.txt";
    static String path2= "Data/Avión.txt";
    public HashTable<String, Passenger> passengers;
    public Plane thePlane;

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
    public void loadPlane() throws IOException {
        File file = new File(path2);
        FileInputStream fis = new FileInputStream(file); //Lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String[] arr;
        line = reader.readLine();
        arr = line.split("::");
        thePlane = new Plane(arr[0], Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
        }

}

