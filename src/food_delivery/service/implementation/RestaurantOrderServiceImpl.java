package food_delivery.service.implementation;

import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.exception.UnauthorizedRestaurantAccessException;
import food_delivery.model.Order;
import food_delivery.repository.OrderRepository;
import food_delivery.service.RestaurantOrderService;

public class RestaurantOrderServiceImpl implements RestaurantOrderService{
	private final OrderRepository orderRepository;
	
	public RestaurantOrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
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

	@Override
	public List<Order> findConfirmedOrderByRestaurant(int restaurantId,OrderStatus orderStatus) {
		return orderRepository.findByRestaurantIdAndStatus(restaurantId,orderStatus);
	}

}
