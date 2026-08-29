package food_delivery.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import food_delivery.enums.OrderStatus;
import food_delivery.exception.IllegalStateTransitionException;

public class Order {
	private String orderId;
	private String customerId;
	private int restaurantId;
	private double totalPrice;
	private List<OrderItem> orderItems;
	private OrderStatus orderStatus;
	private LocalDateTime createdAt;
	public Order(String customerId, int restaurantId, double totalPrice, List<OrderItem> orderItems,
		LocalDateTime createdAt) {
		super();
		this.orderId = UUID.randomUUID().toString();
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.totalPrice = totalPrice;
		this.orderItems = orderItems;
		this.orderStatus = OrderStatus.PAYMENT_PENDING;
		this.createdAt = createdAt;
	}
	public String getOrderId() {
		return orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void confirm() {
		if(orderStatus!=OrderStatus.PAYMENT_PENDING) {
			throw new IllegalStateTransitionException("OrderStatus should be Payment_Pending, to make it as Confirmed");
			
		}
		orderStatus=OrderStatus.CONFIRMED;
	}
	public void cancelOrder() {
		if(orderStatus!=OrderStatus.PAYMENT_PENDING && orderStatus!=OrderStatus.CONFIRMED) {
			throw new IllegalStateTransitionException("OrderStatus should be either Payment_Pending or Confirmed, to cancel it");
			
		}
		orderStatus=OrderStatus.CANCELLED;
	}
	public void makePreparing() {
		if(orderStatus!=OrderStatus.CONFIRMED) {
			throw new IllegalStateTransitionException("Order should be confirmed, to prepare it");
		}
		orderStatus=OrderStatus.PREPARING;
		
	}
	public void makeReady() {
		if(orderStatus!=OrderStatus.PREPARING) {
			throw new IllegalStateTransitionException("Order should be in preparing, to make it as ready");
		}
		orderStatus=OrderStatus.READY_FOR_PICKUP;
		
	}
	
	
    
    
}
