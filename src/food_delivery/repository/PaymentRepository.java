package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.enums.PaymentStatus;
import food_delivery.model.Payment;

public interface PaymentRepository {
	void save(Payment payment);
	Optional<Payment> findById(int paymentId);
	List<Payment>findAllPayments();
	boolean existsById(int paymentId);
	Optional<Payment> findByOrderIdAndPaymentStatus(int orderId,PaymentStatus status);

}
