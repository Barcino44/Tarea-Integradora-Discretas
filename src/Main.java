import model.AirLine;

import java.util.Scanner;

public class Main {
    static AirLine airline = new AirLine();
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("1.Importar\n2.Register Entry\n3.Show entry on plane\n4.\n5.Salir");
            int option = Integer.parseInt(reader.nextLine());
            switch (option) {
                case 1:
                    airline.loadPlane();
                    airline.loadDataBase();
                    System.out.println("The database with info of the passengers and the plane has been loaded");
                    break;
                case 2:
                    airline.registerEntry();
                    System.out.println("The database with the passenger's ID and their arrive order has been loaded");
                    break;
                case 3:
                    airline.showEntry();
                    break;
            }
        }
    }
}