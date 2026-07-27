package food_delivery.exception;

public class InvalidQuantityException extends RuntimeException{
 
    public InvalidQuantityException(String message){
        super(message);
    }
}
