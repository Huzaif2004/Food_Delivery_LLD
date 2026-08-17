package food_delivery.service.implementation;

import java.time.LocalDateTime;
import java.util.Optional;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.RefundRequest;
import food_delivery.enums.PaymentStatus;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.exception.PaymentAlreadyDoneException;
import food_delivery.model.Order;
import food_delivery.model.Payment;
import food_delivery.repository.OrderRepository;
import food_delivery.repository.PaymentRepository;
import food_delivery.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	private final OrderRepository orderRepository;
	private final PaymentRepository paymentRepository;
	
	public PaymentServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
		super();
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
	}

	@Override
	public void initiatePayment(PaymentRequest request) {
		
		Optional<Payment> payment=paymentRepository.findByOrderIdAndPaymentStatus(request.getOrderId(), PaymentStatus.SUCCESSFUL);
		if(payment.isPresent()) {
			throw new PaymentAlreadyDoneException("Payment already successfull for order ID : "+request.getOrderId());
		}
		Order order = orderRepository.findById(request.getOrderId())
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + request.getOrderId() + " does not exist"
	                    ));
		if(order.getTotalPrice()!=request.getAmount()) {
			throw new IllegalArgumentException("Amount mismatch for order: " + request.getOrderId());
		}
		
		
	}

	@Override
	public void refund(RefundRequest refundRequest) {
		// TODO Auto-generated method stub
		
	}

}
