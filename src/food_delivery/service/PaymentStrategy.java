package food_delivery.service;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.dto.RefundResponse;

public interface PaymentStrategy {
	PaymentResponse pay(PaymentRequest request,String paymentId);
	RefundResponse refund(String paymentId,String gatewayTransactionId,double refundAmount);

}
