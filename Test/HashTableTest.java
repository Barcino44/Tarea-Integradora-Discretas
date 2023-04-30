import model.HashTable;
import model.Passenger;
import model.Plane;
import org.junit.Test;
import Exception.PassengerNotFoundException;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTable<String,Passenger> hashTable = new HashTable<>();
    static Plane plane = new Plane("Aereo",15,4,6);
    public void setup1() {

    }

    public void setup2() throws Exception {
        hashTable.insert("56453", new Passenger("56453", "Javier",5461,65,plane,10,3));
        hashTable.insert("98486",new Passenger("98486", "Lina",4865,18,plane,1,4));
        hashTable.insert("38636",new Passenger("34636", "Daniel",1654,25,plane,3,2));
    }
    @Test
    public void insertPassengerInHT() throws Exception{
        setup1();
        //Arrange
        hashTable.insert("26566", new Passenger("26566", "David",4656,70,plane,7,3));
        //Act and assert
        assertEquals(hashTable.search("26566").getName(),"David");
    }
    @Test
    public void validatesearchingInHT() throws Exception {
        //Arrange
        setup2();
        //Act and Assert
        assertEquals(hashTable.search("56453").getName(),"Javier");
    }
    @Test
    public void searchingPassengerThatIsnotInHT(){
        //Arrange
        setup1();
        boolean result=false;
        try {
            hashTable.search("53464");
            result=true;
        }catch (PassengerNotFoundException ex){
            ex.printStackTrace();
        }
        //Act and assert
        assertFalse(result);
    }
}
