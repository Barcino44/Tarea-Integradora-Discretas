package Exception;

public class RowNoExistInPlaneException extends Exception{
    public RowNoExistInPlaneException() {
        super("Some Passengers cannot be added because their row does not exist in plane");
    }
}
