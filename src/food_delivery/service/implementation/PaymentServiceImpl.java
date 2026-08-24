package food_delivery.service.implementation;

import java.util.Optional;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.dto.RefundRequest;
import food_delivery.dto.RefundResponse;
import food_delivery.enums.PaymentStatus;
import food_delivery.enums.RefundStatus;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.exception.PaymentAlreadyDoneException;
import food_delivery.exception.PaymentInProgressException;
import food_delivery.exception.PaymentNotFoundException;
import food_delivery.exception.RefundFailedException;
import food_delivery.factory.PaymentFactory;
import food_delivery.model.Order;
import food_delivery.model.Payment;
import food_delivery.repository.OrderRepository;
import food_delivery.repository.PaymentRepository;
import food_delivery.service.OrderService;
import food_delivery.service.PaymentService;
import food_delivery.service.PaymentStrategy;

public class PaymentServiceImpl implements PaymentService{

	private final OrderRepository orderRepository;
	private final PaymentRepository paymentRepository;
	private final OrderService orderService;
	
	public PaymentServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository,OrderService orderService) {
		super();
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
		this.orderService = orderService;
	}

	@Override
	public PaymentResponse initiatePayment(PaymentRequest request) {
		
		Optional<Payment> existing_payment=paymentRepository.findByOrderIdAndPaymentStatus(request.getOrderId(), PaymentStatus.SUCCESSFUL);
		if(existing_payment.isPresent()) {
			throw new PaymentAlreadyDoneException("Payment already successfull for order ID : "+request.getOrderId());
		}
		Optional<Payment> initiated_payment=paymentRepository.findByOrderIdAndPaymentStatus(request.getOrderId(), PaymentStatus.INITIATED);
		if(existing_payment.isPresent()) {
			throw new PaymentInProgressException("Payment already successfull for order ID : "+request.getOrderId());
		}
		Order order = orderRepository.findById(request.getOrderId())
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + request.getOrderId() + " does not exist"
	                    ));
		if(order.getTotalPrice()!=request.getAmount()) {
			throw new IllegalArgumentException("Amount mismatch for order: " + request.getOrderId());
		}
		Payment payment=new Payment(request.getOrderId(),request.getAmount(),PaymentStatus.INITIATED,request.getType());
		paymentRepository.save(payment);
		
		PaymentStrategy strategy=PaymentFactory.getStrategy(request.getType());
		PaymentResponse response=strategy.pay(request, payment.getPaymentId());
		if(response.getStatus()==PaymentStatus.SUCCESSFUL) {
			payment.makePaymentSuccessfull(response.getGatewayTransactionId());
			orderService.confirm(order.getOrderId());
			
		}
		else {
			payment.makePaymentFailure();
			
		}
		paymentRepository.save(payment);
		return response;
		
	}

	@Override
	public RefundResponse refund(RefundRequest refundRequest) {
		Payment payment = paymentRepository.findById(refundRequest.getPaymentId())
	            .orElseThrow(() -> new PaymentNotFoundException(
	                    "Payment not found: " + refundRequest.getPaymentId()));
		if(payment.getPaymentStatus()!=PaymentStatus.SUCCESSFUL) {
			throw new IllegalStateException("Cannot refund a payment that was not successful");
		}
		PaymentStrategy strategy=PaymentFactory.getStrategy(payment.getType());
		RefundResponse response=strategy.refund(payment.getPaymentId(), payment.getGatewayTransactionId(),payment.getAmount());
		if(response.getRefundStatus()==RefundStatus.SUCCESS) {
			payment.makeRefunded();
		}
		else {
			throw new RefundFailedException("Refund failed for payment: " + payment.getPaymentId());
		}
		paymentRepository.save(payment);
		return response;
		
	}

}
