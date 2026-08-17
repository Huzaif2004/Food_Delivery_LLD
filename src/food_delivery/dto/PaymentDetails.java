package food_delivery.dto;

public class PaymentDetails {
	private String cardNumber;
	private String cvv;
	private String upiId;
	public PaymentDetails(String cardNumber, String cvv, String upiId) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.upiId = upiId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getCvv() {
		return cvv;
	}
	public String getUpiId() {
		return upiId;
	}
	
	

}
