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
    public void setupStage2() throws Exception {
        airline.HTpassengers.insert("46514",new Passenger("46514","Alejandro",642,40,plane,4,4),plane.getRows()*plane.getChairsByRows());
        airline.HTpassengers.insert("64844",new Passenger("64844","Laura",770,19,plane,8,2),plane.getRows()*plane.getChairsByRows());
        airline.HTpassengers.insert("18070",new Passenger("18070","Andres",642,22,plane,9,2),plane.getRows()*plane.getChairsByRows());
    }
    public void setupStage3() throws Exception {
        //Inserting passengers in HT
        airline.HTpassengers.insert("94864",new Passenger("94864","Yeison",645,19,plane,4,4),plane.getRows()*plane.getChairsByRows());
        airline.HTpassengers.insert("65244",new Passenger("65244","Daniel",564,20,plane,8,1),plane.getRows()*plane.getChairsByRows());
        airline.HTpassengers.insert("94848",new Passenger("94848","Alejandra",461,32,plane,8,4),plane.getRows()*plane.getChairsByRows());
        airline.HTpassengers.insert("94474",new Passenger("94474","Cristian",564,44,plane,7,2),plane.getRows()*plane.getChairsByRows());
        //Searching passengers in HT
        Passenger passenger1=airline.HTpassengers.search("94864");
        Passenger passenger2=airline.HTpassengers.search("65244");
        Passenger passenger3=airline.HTpassengers.search("94848");
        //Setting entry order of passengers
        passenger1.setEntryOrder(1);
        passenger2.setEntryOrder(3);
        passenger3.setEntryOrder(2);
        //Addding Passengers in PQ
        airline.PQpassengersIn.insert(passenger1, passenger1.priorty());
        airline.PQpassengersIn.insert(passenger2,passenger2.priorty());
        airline.PQpassengersIn.insert(passenger3,passenger3.priorty());
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
        airline.loadPlane();
        airline.loadDataBase();
        //Assert
        assertNull(airline.HTpassengers.search("Andres"));
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
        //Assert and Assert
        assertNull(airline.HTpassengers.search("80249"));
    }
    @Test
    public void validateRegisterPassengerInPQ() throws Exception {
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
    public void validatePassengerInHTbutNotInPQ() throws Exception {
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
}
