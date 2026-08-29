package food_delivery.service;

import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;

public interface OrderService {
	Order createOrder(String customerId);
	Order viewOrder(String customerId,String orderId);
	List<Order> viewAllOrders();
	void cancelOrder(String orderId);
	void confirm(String orderId);
	

}
