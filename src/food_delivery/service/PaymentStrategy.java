package food_delivery.service;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;

public interface PaymentStrategy {
	PaymentResponse pay(PaymentRequest request,String paymentId);
	void refund(String gatewayTransactionId,double refundAmount);

}
