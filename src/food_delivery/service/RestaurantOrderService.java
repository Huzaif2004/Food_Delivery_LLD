package food_delivery.service;

import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;

public interface RestaurantOrderService {
	void makeReady(String orderId,String restaurantId);
	void makePreparing(String orderId,String restaurantId);
	List<Order>findConfirmedOrderByRestaurant(String restaurantId,OrderStatus orderStatus);

}
