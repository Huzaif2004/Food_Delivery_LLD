package food_delivery.service.implementation;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.service.PaymentStrategy;

public class WalletPayment implements PaymentStrategy{

	@Override
	public PaymentResponse pay(PaymentRequest request,String paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refund(String gatewayTransactionId, double refundAmount) {
		// TODO Auto-generated method stub
		
	}

}
