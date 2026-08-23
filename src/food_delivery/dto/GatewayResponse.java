package food_delivery.dto;

public class GatewayResponse {
	private final boolean approved;
	private final String gatewayTransactionId;
	
	public GatewayResponse(boolean approved, String gatewayTransactionId) {
		super();
		this.approved = approved;
		this.gatewayTransactionId = gatewayTransactionId;
	}
	public boolean isApproved() {
		return approved;
	}
	public String getGatewayTransactionId() {
		return gatewayTransactionId;
	}
	

}
