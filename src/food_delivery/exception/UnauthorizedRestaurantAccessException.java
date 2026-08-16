package food_delivery.exception;

public class UnauthorizedRestaurantAccessException extends RuntimeException{
	public UnauthorizedRestaurantAccessException(String message) {
        super(message);
    }
}
