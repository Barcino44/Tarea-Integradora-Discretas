package model;

import java.io.*;

public class AirLine {
    static String path = "Data/Base de datos de pasajeros.txt";
    static String path2= "Data/Avión.txt";
    static String path3= "Data/idPassengers.txt";
    public HashTable<String, Passenger> HTpassengers;
    public PriorityQueue<Passenger> PQpassengers;
    public Plane thePlane;

    public AirLine() {
        HTpassengers = new HashTable<>();
        PQpassengers = new PriorityQueue<>();
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
            HTpassengers.insert(
                    arr[0], new Passenger(arr[0], (arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),thePlane,Integer.parseInt(arr[4])));
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
    public void registerEntry() throws Exception {
        File file = new File(path3);
        FileInputStream fis = new FileInputStream(file); //Lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String content = "";
        String[] arr;
        while ((line = reader.readLine()) != null) {
            arr = line.split("::");
            Passenger thePassenger = HTpassengers.search(arr[1]);
            thePassenger.setEntryOrder(Integer.parseInt(arr[0]));
            PQpassengers.insert(thePassenger, thePassenger.priorty());
            content += line + "\n";
            }
    }
    public void showEntry() throws Exception {
        while(PQpassengers.getHeapSize()!=0){
            System.out.println(PQpassengers.extract().toString());
        }
    }
}

