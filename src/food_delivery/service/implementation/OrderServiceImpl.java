package food_delivery.service.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import food_delivery.dto.RefundRequest;
import food_delivery.enums.OrderStatus;
import food_delivery.enums.PaymentStatus;
import food_delivery.exception.EmptyCartException;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Cart;
import food_delivery.model.CartItem;
import food_delivery.model.Customer;
import food_delivery.model.Order;
import food_delivery.model.OrderItem;
import food_delivery.model.Payment;
import food_delivery.repository.CustomerRepository;
import food_delivery.repository.OrderRepository;
import food_delivery.repository.PaymentRepository;
import food_delivery.service.CartService;
import food_delivery.service.CustomerService;
import food_delivery.service.OrderService;
import food_delivery.service.PaymentService;
import food_delivery.utils.OrderIDGenerator;

public class OrderServiceImpl implements OrderService{

	private final CustomerRepository customerRepository;
	private final OrderIDGenerator orderIdGenerator;
	private final OrderRepository orderRepository;
	private final CustomerService customerService;
	private final CartService cartService;
	private final PaymentRepository paymentRepository;
	private final PaymentService paymentService;
	public OrderServiceImpl(CustomerRepository customerRepository, OrderIDGenerator orderIdGenerator,
			OrderRepository orderRepository, CustomerService customerService, CartService cartService, PaymentRepository paymentRepository, PaymentService paymentService) {
		super();
		this.customerRepository = customerRepository;
		this.orderIdGenerator = orderIdGenerator;
		this.orderRepository = orderRepository;
		this.customerService = customerService;
		this.cartService = cartService;
		this.paymentRepository = paymentRepository;
		this.paymentService = paymentService;
		
	}

	@Override
	public Order createOrder(String customerId) {
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(()->new UserNotFoundException("User with id"+customerId+" is not found"));
		Cart cart=customer.getCart();
		if(cart.isCartEmpty()) {
			throw new EmptyCartException("Cart is Empty. Can't create order with empty cart");
		}
		List<CartItem> cartItems=cart.getCartItem();
		List<OrderItem> orderItems=new ArrayList<>();
		for(CartItem cartItem:cartItems) {
			OrderItem orderItem=new OrderItem(cartItem.getMenuItem().getMenuItemId(),
					cartItem.getMenuItem().getMenuName(),cartItem.getMenuItem().getPrice(),cartItem.getQuantity());
			orderItems.add(orderItem);
			
		}
		Order o=new Order(customerId,cart.getRestaurantId(),
				cart.getTotal(),orderItems,LocalDateTime.now());
		customerService.addOrder(customer.getCustomerId(), o);
		cartService.clearCart(customerId);
		orderRepository.save(o);
		return o;
		
		
	}

	@Override
	public Order viewOrder(String customerId, String orderId) {

	    Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));

	    if (order.getCustomerId() != customerId) {
	        throw new OrderNotFoundException(
	                "Order does not belong to this customer"
	        );
	    }

	    return order;
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void cancelOrder(String orderId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		Optional<Payment> payment_successful=paymentRepository.findByOrderIdAndPaymentStatus(orderId, PaymentStatus.SUCCESSFUL);
		if(order.getOrderStatus()==OrderStatus.CONFIRMED && payment_successful.isPresent()) {
			//refund
			Payment payment=payment_successful.get();
			paymentService.refund
					(new RefundRequest(payment.getPaymentId(),payment.getAmount(),payment.getGatewayTransactionId()));
			
		}
		order.cancelOrder();
		orderRepository.save(order);
		
	}

	@Override
	public void confirm(String orderId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		order.confirm();
		orderRepository.save(order);
		
	}

	

}
