package food_delivery.exception;

public class MenuItemNotFoundInCartException extends RuntimeException{

	public MenuItemNotFoundInCartException(String message) {
		super(message);
	}
   
}
