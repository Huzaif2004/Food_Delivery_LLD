package food_delivery.service.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.exception.EmptyCartException;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.exception.UnauthorizedRestaurantAccessException;
import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Cart;
import food_delivery.model.CartItem;
import food_delivery.model.Customer;
import food_delivery.model.Order;
import food_delivery.model.OrderItem;
import food_delivery.repository.CustomerRepository;
import food_delivery.repository.OrderRepository;
import food_delivery.service.OrderService;
import food_delivery.utils.OrderIDGenerator;

public class OrderServiceImpl implements OrderService{

	private CustomerRepository customerRepository;
	private OrderIDGenerator orderIdGenerator;
	private OrderRepository orderRepository;
	@Override
	public Order createOrder(int customerId) {
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
		Order o=new Order(orderIdGenerator.generate(),customerId,cart.getRestaurantId(),
				cart.getTotal(),orderItems,LocalDateTime.now());
		customer.addOrder(o);
		orderRepository.save(o);
		return o;
		
		
	}

	@Override
	public Order viewOrder(int customerId, int orderId) {

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
	public void cancelOrder(int customerId, int orderId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		if(order.getOrderStatus()==OrderStatus.CONFIRMED) {
			//refund
		}
		order.cancelOrder();
		orderRepository.save(order);
		
	}

	@Override
	public void confirm(int orderId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		order.confirm();
		orderRepository.save(order);
		
	}

	@Override
	public void makeReady(int orderId, int restaurantId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		if(order.getRestaurantId()!=restaurantId) {
			throw new UnauthorizedRestaurantAccessException(
			        "Restaurant " + restaurantId +
			        " is not authorized to process order " + orderId
			    );
		}
		order.makeReady();
		orderRepository.save(order);
		
		
		
	}

	@Override
	public void makePreparing(int orderId, int restaurantId) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		if(order.getRestaurantId()!=restaurantId) {
			throw new UnauthorizedRestaurantAccessException(
			        "Restaurant " + restaurantId +
			        " is not authorized to process order " + orderId
			    );
		}
		order.makePreparing();
		orderRepository.save(order);
		
	}

}
