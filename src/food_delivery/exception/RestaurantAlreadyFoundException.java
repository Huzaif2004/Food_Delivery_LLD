package food_delivery.exception;

public class RestaurantAlreadyFoundException extends RuntimeException{
    public RestaurantAlreadyFoundException(String message){
        super(message);
    }
    
}
