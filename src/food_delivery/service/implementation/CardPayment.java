package food_delivery.service.implementation;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.service.PaymentStrategy;

public class CardPayment implements PaymentStrategy{


	@Override
	public void refund(String gatewayTransactionId, double refundAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentResponse pay(PaymentRequest request, String paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
