package ui;

import model.AirLine;

import java.util.Scanner;

public class Main {
    static AirLine airline = new AirLine();
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println(banner());
            System.out.print(printMenu());
            int option = Integer.parseInt(reader.nextLine());
            switch (option) {
                case 1:
                    System.out.println("********************************WARNING******************************");
                    System.out.println("    -If the row or the seat of the passenger is not in the plane, \n" +
                            "                       he/she could not be loaded");
                    System.out.println("************************************************************************");
                    if(!AirLine.loadDataBase) {
                        airline.loadPlane();
                        airline.loadDataBase();
                    }
                    System.out.println("The database with info of the passengers and the plane has been loaded!!");
                    break;
                case 2:
                    System.out.println("********************************WARNING******************************");
                    System.out.println("              If the capacity of the plane is reached,\n" +
                            "   just the people with the most priority could enter in the plane");
                    System.out.println("**********************************************************************");
                    if(!AirLine.registerEntry&&AirLine.loadDataBase) {
                        airline.registerEntry();
                    }
                    System.out.println("The database with the passenger's ID and their arrive order has been loaded!!");
                    break;
                case 3:
                    if(AirLine.registerEntry) {
                        airline.showEntry();
                        System.out.println(AirLine.EntryOrder);
                    }
                    else{
                        System.out.println("********************************WARNING*********************************");
                        System.out.println("           The passengers has not been registered");
                        System.out.println("************************************************************************");
                    }
                    break;
                case 4:
                    if(AirLine.registerEntry) {
                        airline.showOut();
                        System.out.println(AirLine.OutOrder);
                    }
                    else {
                        System.out.println("********************************WARNING*********************************");
                        System.out.println("              The passengers has not been registered");
                        System.out.println("************************************************************************");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
}
    public static String banner(){
        return
                """
                        << --------------------------------------------------------------------- >>
                        << -                     WELCOME TO AIRLINE S.A.S.                     - >>
                        << --------------------------------------------------------------------- >>
                                                              █
                                                            ▄▄█▄▄
                                                        ▀▀▀██▀▀▀██▀▀▀
                                                    ▄▄▄▄▄▄▄███████▄▄▄▄▄▄▄
                                                      █▄█  ▀██▄██▀  █▄█
                        """;
    }

    public static String printMenu(){
        return
                """     
                          <<< Menu >>>
                        1. Load DataBase\s
                        2. Register passengers\s
                        3. Show entry Order\s
                        4. Show out order\s
                        0. Exit.
                        """;
    }
}