package Exception;

public class SeatNotExistInPlaneException extends Exception{
    public SeatNotExistInPlaneException(){
        super("The seat does not exist in the plane");
    }
}
