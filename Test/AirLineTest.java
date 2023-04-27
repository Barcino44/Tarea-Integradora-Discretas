import model.AirLine;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AirLineTest {

    AirLine airline= new AirLine();
    public void setup1() {

    }
    public void setup2(){

    }
    @Test
    public void LoadDataBaseTest() throws IOException {
        //Arrange
        setup1();
        //Act
        airline.loadDataBase();
        //Assert
        assertEquals(airline.passengers.search("13826").getName(),"Santiago");
    }

}
