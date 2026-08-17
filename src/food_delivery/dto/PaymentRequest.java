package food_delivery.dto;

import food_delivery.enums.PaymentType;

public class PaymentRequest {
	private int orderId;
	private double amount;
	private PaymentType type;
	private PaymentDetails details;
	public PaymentRequest(int orderId, double amount, PaymentType type, PaymentDetails details) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.type = type;
		this.details = details;
	}
	public int getOrderId() {
		return orderId;
	}
	public double getAmount() {
		return amount;
	}
	public PaymentType getType() {
		return type;
	}
	public PaymentDetails getDetails() {
		return details;
	}
	

}
