package food_delivery.service;

import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;

public interface RestaurantOrderService {
	void makeReady(int orderId,int restaurantId);
	void makePreparing(int orderId,int restaurantId);
	List<Order>findConfirmedOrderByRestaurant(int restaurantId,OrderStatus orderStatus);

}
