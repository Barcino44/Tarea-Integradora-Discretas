import model.AirLine;

import java.util.Scanner;

public class Main {
    static AirLine airline = new AirLine();
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("1.Importar\n2.Registrar entrada\n3.\n4.\n5.Salir");
            int option = Integer.parseInt(reader.nextLine());
            switch (option) {
                case 1:
                    airline.loadPlane();
                    airline.loadDataBase();
                    break;
                case 2:
                    airline.registerEntry();
                    airline.showEntry();
            }
        }
    }
}