package Exception;

public class HeapEmptyException extends Exception  {
    public HeapEmptyException(){
        super("The heap is empty");
    }
}
