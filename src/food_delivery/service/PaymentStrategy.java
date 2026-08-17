package food_delivery.service;

public interface PaymentStrategy {
	void pay(int paymentId,double amount);
	void refund(String gatewayTransactionId,double refundAmount);

}
