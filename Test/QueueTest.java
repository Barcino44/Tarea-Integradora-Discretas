import model.Passenger;
import model.Queue;
import model.Stack;
import org.junit.Test;
import Exception.QueueException;

import static org.junit.Assert.*;

public class QueueTest {
    Queue<Passenger> queue = new Queue<>();

    public void setup1() {

    }

    public void setup2() {
        queue.enqueue(new Passenger("56453", "Javier"));
        queue.enqueue(new Passenger("98486", "Lina"));
        queue.enqueue(new Passenger("34636", "Daniel"));
    }

    @Test
    public void validateFront() throws QueueException {
        //Arrange
        setup2();
        //Act and Assert
        assertEquals(queue.front().getName(), "Javier");
    }
    @Test
    public void validateEnqueue() throws QueueException {
        //Arrange
        setup2();
        //Act
        queue.enqueue(new Passenger("65462","Manuel"));
        //Assert
        assertEquals(queue.getLast().getValue().getName(),"Manuel");
    }
    @Test
    public void validateDequeue() throws QueueException {
        //Arrange
        setup2();
        //Act
        queue.dequeue();
        //Assert
        assertEquals(queue.front().getName(),"Lina");
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

