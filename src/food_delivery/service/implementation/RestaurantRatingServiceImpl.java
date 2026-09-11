package food_delivery.service.implementation;

import food_delivery.enums.OrderStatus;
import food_delivery.exception.OrderNotFoundException;
import food_delivery.model.Order;
import food_delivery.repository.OrderRepository;
import food_delivery.repository.RestaurantRepository;
import food_delivery.service.RestaurantRatingService;

public class RestaurantRatingServiceImpl implements RestaurantRatingService{

	private final OrderRepository orderRepository;
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantRatingServiceImpl(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
		super();
		this.orderRepository = orderRepository;
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public void addRating(String restaurantId, String customerId, String orderId, double rating) {
		Order order = orderRepository.findById(orderId)
	            .orElseThrow(() ->
	                    new OrderNotFoundException(
	                            "Order with id " + orderId + " does not exist"
	                    ));
		if(order.getOrderStatus()!=OrderStatus.DELIVERED) {
			
		}
		
		
	}

	@Override
	public void addRating(String restaurantId, String customerId, String orderId, double rating, String comment) {
		// TODO Auto-generated method stub
		
	}

}
