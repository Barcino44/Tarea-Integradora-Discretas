import model.AirLine;
import model.Passenger;
import model.Stack;
import org.junit.Test;
import Exception.*;
import java.io.IOException;

import static org.junit.Assert.*;

public class AirLineTest {

    AirLine airline= new AirLine();
    public void setup1() {

    }
    @Test
    public void validateifDataBaseLoadInHT() throws IOException {
        //Arrange
        setup1();
        //Act
        airline.loadDataBase();
        //Assert
        assertEquals(airline.HTpassengers.search("80249").getName(),"Ana");
    }
    @Test
    public void validateThatPassengerIsnotInHT() {
        boolean result=false;
        //Arrange
        setup1();
        //Act
        try {
            airline.loadDataBase();
            airline.HTpassengers.search("6451");
            result=true;
        } catch (PassengerNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateIfPlaneIsLoaded() throws IOException {
        //Arrange
        setup1();
        //Act
        airline.loadPlane();
        //Assert
        assertEquals(airline.thePlane.getName(),"Barcino'sPlane");
    }
}
