package food_delivery.dto;

public class RefundRequest {
    private String paymentId;
    private double refundAmount;
    private String gatewayTransactionId;
	public RefundRequest(String paymentId, double refundAmount, String gatewayTransactionId) {
		super();
		this.paymentId = paymentId;
		this.refundAmount = refundAmount;
		this.gatewayTransactionId = gatewayTransactionId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public String getGatewayTransactionId() {
		return gatewayTransactionId;
	}
    
}
