import model.AirLine;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static AirLine arline = new AirLine();
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("1.Importar\n2.Anadir\n3.Mostrar mallas\n4.Indice de peligrosidad\n5.Salir");
            int option = Integer.parseInt(reader.nextLine());
            switch (option) {
                case 1:
                    arline.loadDataBase();
                    break;

            }
        }
    }
}