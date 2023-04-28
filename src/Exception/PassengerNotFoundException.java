package Exception;

public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException(){
        super("The passenger was not found");
    }
}
