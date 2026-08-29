package food_delivery.service;

import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;

public interface RestaurantOrderService {
	void makeReady(String orderId,int restaurantId);
	void makePreparing(String orderId,int restaurantId);
	List<Order>findConfirmedOrderByRestaurant(int restaurantId,OrderStatus orderStatus);

}
