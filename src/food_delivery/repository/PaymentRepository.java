package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.enums.OrderStatus;
import food_delivery.enums.PaymentStatus;
import food_delivery.model.Order;
import food_delivery.model.Payment;

public interface PaymentRepository {
	void save(Payment payment);
	Optional<Payment> findById(String paymentId);
	List<Payment>findAllPayments();
	boolean existsById(String paymentId);
	Optional<Payment> findByOrderIdAndPaymentStatus(String orderId,PaymentStatus status);
	

}
