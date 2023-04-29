import model.AirLine;
import model.Passenger;
import model.Plane;
import model.Stack;
import org.junit.Test;
import Exception.*;
import java.io.IOException;

import static org.junit.Assert.*;

public class AirLineTest {
    AirLine airline= new AirLine();
    static Plane plane = new Plane("Aereo",15,4,6);
    public void setupStage1() {

    }
    public void setupStage2(){
        airline.HTpassengers.insert("46514",new Passenger("46514","Alejandro",642,40,plane,4));
        airline.HTpassengers.insert("64844",new Passenger("64844","Laura",770,19,plane,8));
        airline.HTpassengers.insert("18070",new Passenger("18070","Andres",642,22,plane,28));
    }
    public void setupStage3() throws Exception {
        //Inserting passengers in HT
        airline.HTpassengers.insert("94864",new Passenger("94864","Yeison",645,19,plane,4));
        airline.HTpassengers.insert("65244",new Passenger("65244","Daniel",564,20,plane,8));
        airline.HTpassengers.insert("94848",new Passenger("94848","Alejandra",461,32,plane,8));
        airline.HTpassengers.insert("94474",new Passenger("94474","Cristian",564,44,plane,7));
        //Searching passengers in HT
        Passenger passenger1=airline.HTpassengers.search("94864");
        Passenger passenger2=airline.HTpassengers.search("65244");
        Passenger passenger3=airline.HTpassengers.search("94848");
        //Setting entry order of passengers
        passenger1.setEntryOrder(1);
        passenger2.setEntryOrder(3);
        passenger3.setEntryOrder(2);
        //Addding Passengers in PQ
        airline.PQpassengers.insert(passenger1, passenger1.priorty());
        airline.PQpassengers.insert(passenger2,passenger2.priorty());
        airline.PQpassengers.insert(passenger3,passenger3.priorty());
    }
    @Test
    public void validateifDataBaseisLoadInHT() throws IOException {
        //Arrange
        setupStage1();
        //Act
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
    public void validateThatPassengerIsinHT(){
        //Arrange
        setupStage2();
        //Act
        Passenger thePassenger =airline.HTpassengers.search("18070");
        //Act
        assertEquals(thePassenger.getName(),"Andres");
    }
    @Test
    public void validateThatPassengerIsnotInHT() {
        boolean result=false;
        //Arrange
        setupStage2();
        //Act
        try {
            airline.HTpassengers.search("80249");
            result=true;
        } catch (PassengerNotFoundException ex) {
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateRegisterPassengerInPQ() throws Exception {
        //Arrange
        setupStage3();
        //Act and Assert
        assertEquals(airline.PQpassengers.extract().getName(),"Yeison");
    }
    @Test
    public void entryOrderInCaseOfDrawPriorty() throws Exception {
        //Arrange
        setupStage3();
        //Act
        airline.PQpassengers.extract();
        //Assert
        assertEquals(airline.PQpassengers.extract().getName(),"Alejandra");
    }
    @Test
    public void validatePassengerInHTbutNotInPQ() throws Exception {
        //Arrange
        setupStage3();
        //Act
        boolean isInPQ=false;
        while (airline.PQpassengers.getHeapSize()!=0&&!isInPQ){
            if(airline.PQpassengers.extract().getName().equals("Cristian")){
                isInPQ=true;
            }
        }
        //Assert
        assertEquals(airline.HTpassengers.search("94474").getName(),"Cristian");
        assertFalse(isInPQ);
    }
}
