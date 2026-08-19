package food_delivery.service.implementation;

import java.util.UUID;

import food_delivery.dto.GatewayResponse;
import food_delivery.dto.PaymentRequest;
import food_delivery.dto.PaymentResponse;
import food_delivery.enums.PaymentStatus;
import food_delivery.enums.PaymentType;
import food_delivery.exception.PaymentValidationException;
import food_delivery.service.PaymentStrategy;

public class CardPayment implements PaymentStrategy{


	@Override
	public void refund(String gatewayTransactionId, double refundAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentResponse pay(PaymentRequest request, String paymentId) {
		String cardNumber=request.getDetails().getCardNumber();
		String cvv=request.getDetails().getCvv();
		validateCardAndCvv(cardNumber,cvv);
		GatewayResponse result=gatewayTransaction(paymentId,cardNumber,cvv,request.getAmount());
		if(!result.isApproved()) {
			return new PaymentResponse(paymentId,request.getAmount(), PaymentType.CARD, PaymentStatus.FAILURE,result.getGatewayTransactionId());
		}
		return new PaymentResponse(paymentId,request.getAmount(), PaymentType.CARD, PaymentStatus.SUCCESSFUL,result.getGatewayTransactionId());
		
	}
	public void validateCardAndCvv(String cardNumber,String cvv) {
		if(cardNumber==null||cardNumber.length()!=16) {
			throw new PaymentValidationException("Car number must be 16 digits");
		}
		if(cvv==null||cvv.length()!=3) {
			throw new PaymentValidationException("Cvv number must be 3 digits");
		}
	}
	public GatewayResponse gatewayTransaction(String paymentId,String cardNumber,String cvv,double amount) {
		boolean approved=Math.random()>0.1;
		if(approved) {
			return new GatewayResponse(approved, "CARD-"+UUID.randomUUID().toString());
		}
		else {
			return new GatewayResponse(approved, null);
		}
	}

}
