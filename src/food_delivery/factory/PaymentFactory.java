package food_delivery.factory;

import food_delivery.enums.PaymentType;
import food_delivery.service.PaymentStrategy;
import food_delivery.service.implementation.CardPayment;
import food_delivery.service.implementation.UpiPayment;

public class PaymentFactory {
	public static PaymentStrategy getStrategy(PaymentType type) {
		switch (type) {
        case CARD:
            return new CardPayment();
        case UPI:
            return new UpiPayment();
    
        default:
            throw new IllegalArgumentException("Unsupported payment type: " + type);
    }
		
	}

}
