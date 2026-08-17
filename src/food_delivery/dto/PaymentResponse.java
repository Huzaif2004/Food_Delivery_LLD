package food_delivery.dto;

import food_delivery.enums.PaymentStatus;
import food_delivery.enums.PaymentType;

public class PaymentResponse {
	private int paymentId;
	private double amount;
	private PaymentType type;
	private PaymentStatus status;
	private String gatewayTransactionId;
	public PaymentResponse(int paymentId, int orderId, double amount, PaymentType type, PaymentStatus status,String gatewayTransactionId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.gatewayTransactionId=gatewayTransactionId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	
	public String getGatewayTransactionId() {
		return gatewayTransactionId;
	}
	public double getAmount() {
		return amount;
	}
	public PaymentType getType() {
		return type;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	
	

}
