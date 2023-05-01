import model.Passenger;
import model.Plane;
import model.Queue;
import org.junit.Test;
import Exception.QueueException;

import static org.junit.Assert.*;

public class QueueTest {
    Queue<Passenger> queue = new Queue<>();
    static Plane plane = new Plane("Aereo",15,4,6);
    public void setup1() {

    }

    public void setup2() throws Exception {
        queue.enqueue(new Passenger("56453", "Javier",5461,65,plane,10,3));
        queue.enqueue(new Passenger("98486", "Lina",4865,18,plane,1,4));
        queue.enqueue(new Passenger("34636", "Daniel",1654,25,plane,3,2));
    }

    @Test
    public void validateFront() throws Exception {
        //Arrange
        setup2();
        //Act and Assert
        assertEquals(queue.front().getName(), "Javier");
    }
    @Test
    public void validateEnqueue() throws Exception {
        //Arrange
        setup2();
        //Act
        queue.enqueue(new Passenger("65462","Manuel",6555,47,plane,12,4));
        //Assert
        assertEquals(queue.getLast().getValue().getName(),"Manuel");
    }
    @Test
    public void validateDequeue() throws Exception {
        //Arrange
        setup2();
        //Act
        queue.dequeue();
        //Assert
        assertEquals(queue.front().getName(),"Lina");
    }
    @Test
    public void validateEmptyQueue(){
        //Arrange
        setup1();
        //Act and Assert
        assertTrue(queue.isEmpty());
    }
    @Test
    public void validateDequeueEmptyQueue() throws QueueException {
        //Arrange
        boolean result=false;
        setup1();
        //Act
        try {
            queue.dequeue();
            result=true;
        }catch (QueueException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validateFrontEmptyQueue(){
        //Arrange
        boolean result=false;
        setup1();
        //Act
        try {
            queue.front();
            result=true;
        }catch (QueueException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
}

