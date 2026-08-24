package food_delivery.dto;

import food_delivery.enums.RefundStatus;

public class RefundResponse {
	private RefundStatus refundStatus;
	private String refundTransactionId;
	private double refundAmount;
	private String paymentId;
	public RefundResponse(RefundStatus refundStatus, String refundTransactionId, double refundAmount,
			String paymentId) {
		super();
		this.refundStatus = refundStatus;
		this.refundTransactionId = refundTransactionId;
		this.refundAmount = refundAmount;
		this.paymentId = paymentId;
	}
	public RefundStatus getRefundStatus() {
		return refundStatus;
	}
	public String getRefundTransactionId() {
		return refundTransactionId;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public String getPaymentId() {
		return paymentId;
	}
	
	

}
