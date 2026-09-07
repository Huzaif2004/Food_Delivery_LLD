package food_delivery.dto;

import food_delivery.model.Location;

public class DeliveryAgentUpdateRequest {
	private final String deliveryAgentId;
	private final String deliveryAgentName;
	private final String phoneNumber;
	private final String vehicleNumber;
	public DeliveryAgentUpdateRequest(String deliveryAgentName, String phoneNumber, String vehicleNumber, String deliveryAgentId) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.deliveryAgentName = deliveryAgentName;
		this.phoneNumber = phoneNumber;
		this.vehicleNumber = vehicleNumber;
	}
	public String getDeliveryAgentName() {
		return deliveryAgentName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}
	
	
	
}
