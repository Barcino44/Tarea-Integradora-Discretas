import model.HashTable;
import model.Heap;
import model.Passenger;
import model.Plane;
import org.junit.Test;
import Exception.HeapEmptyException;

import static org.junit.Assert.*;

public class HeapTest {
    Heap<Passenger> heap = new Heap<>();
    static Plane plane = new Plane("Aereo", 15, 4, 6);

    public void setup1() {

    }

    public void setup2() throws Exception {
        heap.insertPassenger(new Passenger("56453", "Javier", 5461, 65, plane, 10, 3), 15);
        heap.insertPassenger(new Passenger("98486", "Lina", 4865, 18, plane, 1, 4), 12);
        heap.insertPassenger(new Passenger("34636", "Daniel", 1654, 25, plane, 3, 2), 20);
    }
    @Test
    public void validateInsertPassengerInHeap()throws Exception{
        //Arrange
        setup1();
        //Act
        heap.insertPassenger(new Passenger("56540", "Mauricio", 5464, 70, plane, 12, 3), 18);
        //Assert
        assertEquals(heap.getHeapsize(),1);
    }
    @Test
    public void validateRootNull(){
        //Arrange
        setup1();
        //Act
        boolean result=false;
        try {
            heap.getRoot();
            result=true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateIfHeapExtractMajorKey() throws Exception {
        //Arrange
        setup2();
        //Act and Assert
        assertEquals(heap.extract().getName(),"Daniel");
    }
}

