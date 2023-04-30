package model;

import java.io.*;
import Exception.*;

public class AirLine {
    static String path = "Data/Base de datos de pasajeros.txt";
    static String path2 = "Data/Avión.txt";
    static String path3 = "Data/idPassengers.txt";
    public static boolean loadDataBase=false;
    public static boolean registerEntry=false;
    public HashTable<String, Passenger> HTpassengers;
    public PriorityQueue<Passenger> PQpassengersIn;
    public PriorityQueue<Passenger> PQpassengersOut;
    public Stack<Passenger> StackpassengerOut;
    public Plane thePlane;

    public AirLine() {
        HTpassengers = new HashTable<>();
        PQpassengersIn = new PriorityQueue<>();
        PQpassengersOut = new PriorityQueue<>();
        StackpassengerOut =new Stack<>();
    }
    public void loadDataBase() throws Exception {
        loadDataBase=true;
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file); //Lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String[] arr;
        String content = "";
        while ((line = reader.readLine()) != null) {
            arr = line.split("::");
            if (Integer.parseInt(arr[4]) <= thePlane.getRows()) {
                HTpassengers.insert(
                        arr[0], new Passenger(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), thePlane, Integer.parseInt(arr[4]),Integer.parseInt(arr[5])), thePlane.getRows() * thePlane.getChairsByRows());
            }
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
        thePlane = new Plane(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
    }

    public void registerEntry() throws Exception {
        registerEntry=true;
        File file = new File(path3);
        FileInputStream fis = new FileInputStream(file); //Lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String content = "";
        String[] arr;
        while ((line = reader.readLine()) != null) {
            arr = line.split("::");
            if (HTpassengers.search(arr[1]) != null) {
                Passenger thePassenger = HTpassengers.search(arr[1]);
                thePassenger.setEntryOrder(Integer.parseInt(arr[0]));
                PQpassengersIn.insert(thePassenger, thePassenger.priorty());
                content += line + "\n";
            }
        }
    }
    public void showEntry() throws Exception {
        int counter=0;
        while (PQpassengersIn.getHeapSize() != 0&&thePlane.getChairsByRows()* thePlane.getRows()>counter) {
            counter++;
            System.out.println(PQpassengersIn.extract().toString());
        }
    }
    public void registerExit() throws Exception {
        File file = new File(path3);
        FileInputStream fis = new FileInputStream(file); //Lector
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = "";
        String content = "";
        String[] arr;
        while ((line = reader.readLine()) != null) {
            arr = line.split("::");
            if (HTpassengers.search(arr[1]) != null) {
                Passenger thePassenger = HTpassengers.search(arr[1]);
                thePassenger.setEntryOrder(Integer.parseInt(arr[0]));
                PQpassengersOut.insert(thePassenger, thePassenger.priorityOut());
                content += line + "\n";
            }
        }
    }
    public void toStack() throws Exception {
        int counter=0;
        while (PQpassengersOut.getHeapSize() != 0&&thePlane.getChairsByRows()* thePlane.getRows()>counter) {
            StackpassengerOut.push(PQpassengersOut.extract());
            counter++;
        }
    }
    public void showOut() throws Exception {
        toStack();
        while (!StackpassengerOut.isEmpty()) {
            System.out.println(StackpassengerOut.pop());
        }
    }
}

