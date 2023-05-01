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
        hashTable.insert("65684", new Passenger("65684", "Esteban",1231,52,plane,10,4));
        hashTable.insert("84935",new Passenger("84935", "Felipe",2686,16,plane,2,1));
        hashTable.insert("49884",new Passenger("49884", "Sergio",4636,43,plane,9,2));
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
        assertEquals(hashTable.search("65684").getName(),"Esteban");
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
