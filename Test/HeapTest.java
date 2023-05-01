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
        heap.insertPassenger(new Passenger("56453", "Amy", 5461, 23, plane, 11, 1), 15);
        heap.insertPassenger(new Passenger("98486", "Sebástian", 4894, 78, plane, 12, 4), 12);
        heap.insertPassenger(new Passenger("34636", "Facundo", 7696, 45, plane, 8, 4), 20);
    }
    @Test
    public void validateInsertPassengerInHeap()throws Exception{
        //Arrange
        setup1();
        //Act
        heap.insertPassenger(new Passenger("56540", "Mauricio", 5464, 40, plane, 12, 3), 18);
        //Assert
        assertEquals(heap.getHeapsize(),1);
    }
    @Test
    public void validateRoot() throws Exception {
        //Arrange
        setup2();
        //Act and Assert
        assertEquals(heap.getRoot().getName(),"Facundo");
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
        assertEquals(heap.extract().getName(),"Facundo");
    }
    @Test
    public void validateExtractingHeapWithoutRoot(){
        //Arrange
        setup1();
        //Act
        boolean result=false;
        try{
            heap.extract();
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
}

