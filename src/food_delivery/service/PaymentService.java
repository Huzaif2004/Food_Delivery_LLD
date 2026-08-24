package food_delivery.service;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.dto.RefundRequest;
import food_delivery.dto.RefundResponse;

public interface PaymentService {
	PaymentResponse initiatePayment(PaymentRequest request);
	RefundResponse refund(RefundRequest refundRequest);

}
