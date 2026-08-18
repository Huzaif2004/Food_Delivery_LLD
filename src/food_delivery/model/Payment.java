package food_delivery.model;

import java.time.LocalDateTime;
import java.util.UUID;

import food_delivery.enums.PaymentStatus;
import food_delivery.enums.PaymentType;
import food_delivery.exception.IllegalStateTransitionException;

public class Payment {
	private String paymentId;
	private int orderId;
	private double amount;
	private PaymentStatus paymentStatus;
	private LocalDateTime createdAt;
	private PaymentType type;
	private String gatewayTransactionId;
	public Payment(int orderId, double amount, PaymentStatus paymentStatus,
			PaymentType type) {
		super();
		this.paymentId = UUID.randomUUID().toString();
		this.orderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.createdAt = LocalDateTime.now();
		this.type = type;
	}
	public String getPaymentId() {
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
	public void makePaymentSuccessfull(String transactionId) {
		if(paymentStatus!=PaymentStatus.INITIATED) {
		    throw new IllegalStateTransitionException("Payment Status should be Initiated to become Successful");
		}
		paymentStatus=PaymentStatus.SUCCESSFUL;
		gatewayTransactionId=transactionId;
		
	}
	public void makePaymentFailure() {
		if(paymentStatus!=PaymentStatus.INITIATED) {
			throw new IllegalStateTransitionException("Payment Status should be Initiated to become Successful");
		}
		paymentStatus=PaymentStatus.FAILURE;
		
		
	}
	
	
	

}
