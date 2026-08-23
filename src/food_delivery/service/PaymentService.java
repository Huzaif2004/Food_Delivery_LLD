package food_delivery.service;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.dto.RefundRequest;

public interface PaymentService {
	PaymentResponse initiatePayment(PaymentRequest request);
	void refund(RefundRequest refundRequest);

}
