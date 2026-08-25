package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.enums.OrderStatus;
import food_delivery.enums.PaymentStatus;
import food_delivery.model.Order;
import food_delivery.model.Payment;
import food_delivery.repository.PaymentRepository;

public class InMemoryPaymentRepository implements PaymentRepository{
	private Map<String,Payment> payments=new HashMap<>();

	@Override
	public void save(Payment payment) {
		payments.put(payment.getPaymentId(), payment);
	}

	@Override
	public Optional<Payment> findById(String paymentId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(payments.get(paymentId));
	}

	@Override
	public List<Payment> findAllPayments() {
		// TODO Auto-generated method stub
		return new ArrayList<>(payments.values());
	}

	@Override
	public boolean existsById(String paymentId) {
		// TODO Auto-generated method stub
		return payments.containsKey(paymentId);
	}

	@Override
	public Optional<Payment> findByOrderIdAndPaymentStatus(int orderId, PaymentStatus status) {
		// TODO Auto-generated method stub
		return payments.values().stream().filter(p->p.getOrderId()==orderId).filter(p->p.getPaymentStatus()==status).findFirst();
		
	}

	

}
