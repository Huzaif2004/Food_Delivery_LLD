package food_delivery.service.implementation;

import java.util.Optional;

import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.dto.RefundRequest;
import food_delivery.enums.PaymentStatus;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.exception.PaymentAlreadyDoneException;
import food_delivery.exception.PaymentInProgressException;
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
		return response;
		
	}

	@Override
	public void refund(RefundRequest refundRequest) {
		// TODO Auto-generated method stub
		
	}

}
