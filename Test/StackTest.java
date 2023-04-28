import model.Passenger;
import model.Stack;
import Exception.StackException;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack<Passenger> stack = new Stack<>();
    public void setup1() {

    }
    public void setup2(){
        stack.push(new Passenger("56453","Daron"));
        stack.push(new Passenger("98486","José"));
        stack.push(new Passenger("34636", "Dayana"));
    }
    @Test
    public void validateTopStack() throws StackException {
        //Arrange
        setup2();
        //Act and Assert
        assertEquals(stack.top().getName(),"Dayana");
    }
    @Test
    public void valdatePushStack() throws StackException {
        //Arrange
        setup2();
        //Act
        stack.push(new Passenger("65154","Mariana"));
        //Assert
        assertEquals(stack.top().getName(),"Mariana");
    }
    @Test
    public void validatePopStack() throws StackException {
        //Arrange
        setup2();
        //Act
        stack.pop();
        //Assert
        assertEquals(stack.top().getName(),"José");
    }
    @Test
    public void validateEmptyStack(){
        //Arrange
        setup1();
        //Act and Assert
        assertTrue(stack.isEmpty());
    }
    @Test
    public void validateTopInEmptyStack(){
        //Arrange
        setup1();
        //Act
        boolean result=false;
        try{
            stack.top();
            result=true;
        }catch (StackException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
    @Test
    public void validatePopInEmptyStack(){
        //Arrange
        setup1();
        //Act
        boolean result=false;
        try{
            stack.top();
            result=true;
        }catch (StackException ex){
            ex.printStackTrace();
        }
        //Assert
        assertFalse(result);
    }
}
