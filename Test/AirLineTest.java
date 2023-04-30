import model.AirLine;
import model.Passenger;
import model.Plane;
import org.junit.Test;
import Exception.*;
import java.io.IOException;

import static org.junit.Assert.*;

public class AirLineTest {
    AirLine airline= new AirLine();
    static Plane plane = new Plane("Aereo",15,4,6);
    public void setupStage1() {

    }
    public void setupStage2() throws Exception {
        airline.HTpassengers.insert("46514",new Passenger("46514","Alejandro",642,40,plane,4,4));
        airline.HTpassengers.insert("64844",new Passenger("64844","Laura",770,19,plane,8,2));
        airline.HTpassengers.insert("61546",new Passenger("61546","MariaJose",846,18,plane,3,1));
    }
    public void setupStage3() throws Exception {
        //Inserting passengers in HT
        airline.HTpassengers.insert("94864",new Passenger("94864","Yeison",645,19,plane,4,4));
        airline.HTpassengers.insert("65244",new Passenger("65244","Daniel",564,20,plane,8,1));
        airline.HTpassengers.insert("94848",new Passenger("94848","Alejandra",461,32,plane,8,4));
        airline.HTpassengers.insert("94474",new Passenger("94474","Cristian",564,44,plane,7,2));
        //Searching passengers in HT
        Passenger passenger1=airline.HTpassengers.search("94864");
        Passenger passenger2=airline.HTpassengers.search("65244");
        Passenger passenger3=airline.HTpassengers.search("94848");
        //Setting entry order of passengers
        passenger1.setEntryOrder(1);
        passenger2.setEntryOrder(3);
        passenger3.setEntryOrder(2);
        //Addding Passengers in PQ
        airline.PQpassengersIn.insert(passenger1, passenger1.priortyEntry());
        airline.PQpassengersIn.insert(passenger2,passenger2.priortyEntry());
        airline.PQpassengersIn.insert(passenger3,passenger3.priortyEntry());
    }
    public void setupStage4() throws Exception {
        //Inserting passengers in HT
        airline.HTpassengers.insert("48654",new Passenger("48654","Gustavo",645,62,plane,4,4));
        airline.HTpassengers.insert("84901",new Passenger("84901","Federico",564,45,plane,15,1));
        airline.HTpassengers.insert("98614",new Passenger("98614","Ana Sofia",5135,22,plane,12,2));
        airline.HTpassengers.insert("59747",new Passenger("59747","Margarita",2568,44,plane,12,3));
        //Searching passengers in HT
        Passenger passenger1=airline.HTpassengers.search("48654");
        Passenger passenger2=airline.HTpassengers.search("84901");
        Passenger passenger3=airline.HTpassengers.search("98614");
        Passenger passenger4=airline.HTpassengers.search("59747");
        //Setting entry order of passengers
        passenger1.setEntryOrder(1);
        passenger2.setEntryOrder(3);
        passenger3.setEntryOrder(4);
        passenger4.setEntryOrder(2);
        //Addding Passengers in PQOut
        airline.PQpassengersOut.insert(passenger1, passenger1.priorityOut());
        airline.PQpassengersOut.insert(passenger2,passenger2.priorityOut());
        airline.PQpassengersOut.insert(passenger3,passenger3.priorityOut());
        airline.PQpassengersOut.insert(passenger4,passenger4.priorityOut());
    }
    @Test
    public void validateifDataBaseisLoadInHT() throws Exception {
        //Arrange
        setupStage1();
        //Act
        airline.loadPlane();
        airline.loadDataBase();
        //Assert
        assertEquals(airline.HTpassengers.search("80249").getName(),"Ana");
    }
    @Test
    public void validateIfPlaneIsLoaded() throws IOException {
        //Arrange
        setupStage1();
        //Act
        airline.loadPlane();
        //Assert
        assertEquals(airline.thePlane.getName(),"Barcino'sPlane");
    }
    @Test
    public void validateifIsLoadedAPassengerThatNumberOfRowIsNotInPlane() throws Exception {
        //Arrange
        setupStage2();
        //Act
        boolean result=false;
        try{;
            airline.HTpassengers.insert("18070",new Passenger("18070","Andres",642,22,plane,20,2));
            result=true;
        }catch (RowNoExistInPlaneException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateifIsLoadedAPassengerThatNumberOfSeatIsNotInPlane() throws Exception {
        setupStage2();
        //Act
        boolean result=false;
        try{;
            airline.HTpassengers.insert("01963",new Passenger("01963","Natalia",642,45,plane,4,88));
            result=true;
        }catch (SeatNotExistInPlaneException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateThatPassengerIsinHT() throws Exception {
        //Arrange
        setupStage2();
        //Act
        Passenger thePassenger =airline.HTpassengers.search("64844");
        //Act
        assertEquals(thePassenger.getName(),"Laura");
    }
    @Test
    public void validateThatPassengerIsnotInHT() throws Exception {
        //Arrange
        setupStage2();
        //Act
        boolean result=false;
        try {
            airline.HTpassengers.search("80249");
            result=true;
        }catch (PassengerNotFoundException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateRegisterPassengerInPQIn() throws Exception {
        //Arrange
        setupStage3();
        //Act and Assert
        assertEquals(airline.PQpassengersIn.extract().getName(),"Yeison");
    }
    @Test
    public void entryOrderInCaseOfDrawPriorty() throws Exception {
        //Arrange
        setupStage3();
        //Act
        airline.PQpassengersIn.extract();
        //Assert
        assertEquals(airline.PQpassengersIn.extract().getName(),"Alejandra");
    }
    @Test
    public void validatePassengerInHTbutNotInPQIn() throws Exception {
        //Arrange
        setupStage3();
        //Act
        boolean isInPQ=false;
        while (airline.PQpassengersIn.getHeapSize()!=0&&!isInPQ){
            if(airline.PQpassengersIn.extract().getName().equals("Cristian")){
                isInPQ=true;
            }
        }
        //Assert
        assertEquals(airline.HTpassengers.search("94474").getName(),"Cristian");
        assertFalse(isInPQ);
    }
    @Test
    public void validateExitOrder() throws Exception{
        //Arrange
        setupStage4();
        //Act
        while (airline.PQpassengersOut.getHeapSize()!=0) {
            airline.StackpassengerOut.push(airline.PQpassengersOut.extract());
        }
        //Assert
        assertEquals(airline.StackpassengerOut.pop().getName(),"Gustavo");
    }
    @Test
    public void outOrderInCaseDrawPriority() throws Exception {
        //Arrange
        setupStage4();
        //Act
        while (airline.PQpassengersOut.getHeapSize()!=0) {
            airline.StackpassengerOut.push(airline.PQpassengersOut.extract()); //Pongo a los pasajeros en la pila
        }
        airline.StackpassengerOut.pop(); //Saco al primero (Gustavo)
        //Assert
        assertEquals(airline.StackpassengerOut.pop().getName(),"Margarita"); //Margarita y Ana estan empatadas en todo, pero Margarita llego primero.
    }
}
