package food_delivery.service.implementation;

import java.util.UUID;

import food_delivery.dto.GatewayResponse;
import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.dto.RefundResponse;
import food_delivery.enums.PaymentStatus;
import food_delivery.enums.PaymentType;
import food_delivery.enums.RefundStatus;
import food_delivery.exception.PaymentValidationException;
import food_delivery.service.PaymentStrategy;

public class UpiPayment implements PaymentStrategy{

	@Override
	public PaymentResponse pay(PaymentRequest request, String paymentId) {
		// TODO Auto-generated method stub
		String upiId=request.getDetails().getUpiId();
		validateUpiId(upiId);
		GatewayResponse result=gatewayTransaction(paymentId,upiId,request.getAmount());
		if(!result.isApproved()) {
			return new PaymentResponse(paymentId,request.getAmount(), PaymentType.UPI, PaymentStatus.FAILURE,result.getGatewayTransactionId());
		}
		return new PaymentResponse(paymentId,request.getAmount(), PaymentType.UPI, PaymentStatus.SUCCESSFUL,result.getGatewayTransactionId());
	}

	@Override
	public RefundResponse refund(String paymentId,String gatewayTransactionId, double refundAmount) {
		// TODO Auto-generated method stub
		GatewayResponse response=gatewayRefundTransaction(gatewayTransactionId, refundAmount);
		if(response.isApproved()) {
			return new RefundResponse(RefundStatus.SUCCESS,response.getGatewayTransactionId(),refundAmount,paymentId);
		}
		return new RefundResponse(RefundStatus.FAILURE,null,refundAmount,paymentId);
		
	}
	public void validateUpiId(String upiId) {
		if (upiId == null || !upiId.matches("^[\\w.\\-]+@[\\w]+$")) {
            throw new PaymentValidationException("Invalid UPI ID: " + upiId);
        }
		
	}
	public GatewayResponse gatewayTransaction(String paymentId,String upiId,double amount) {
		boolean approved=Math.random()>0.1;
		if(approved) {
			return new GatewayResponse(approved, "UPI-"+UUID.randomUUID().toString());
		}
		else {
			return new GatewayResponse(approved, null);
		}
	}
	public GatewayResponse gatewayRefundTransaction(String gatewaytransactionId,double amount) {
		boolean approved=Math.random()>0.1;
		if(approved) {
			return new GatewayResponse(approved,"REFUND-" + UUID.randomUUID());
		}
		return new GatewayResponse(approved,null);
		
	}

}
