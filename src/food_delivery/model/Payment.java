package food_delivery.model;

import java.time.LocalDateTime;

import food_delivery.enums.PaymentStatus;
import food_delivery.enums.PaymentType;

public class Payment {
	private int paymentId;
	private int orderId;
	private double amount;
	private PaymentStatus paymentStatus;
	private LocalDateTime createdAt;
	private PaymentType type;
	private String gatewayTransactionId;
	public Payment(int paymentId, int orderId, double amount, PaymentStatus paymentStatus, LocalDateTime createdAt,
			PaymentType type, String gatewayTransactionId) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.createdAt = createdAt;
		this.type = type;
		this.gatewayTransactionId = gatewayTransactionId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public double getAmount() {
		return amount;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public PaymentType getType() {
		return type;
	}
	public String getGatewayTransactionId() {
		return gatewayTransactionId;
	}
	
	

}
