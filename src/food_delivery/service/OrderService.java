package food_delivery.service;

import java.util.List;

import food_delivery.model.Order;

public interface OrderService {
	Order createOrder(int customerId);
	Order viewOrder(int customerId,int orderId);
	List<Order> viewAllOrders();
	void cancelOrder(int orderId);
	void confirm(int orderId);
	void makeReady(int orderId,int restaurantId);
	void makePreparing(int orderId,int restaurantId);

}
