package food_delivery.dto;

import food_delivery.enums.DeliveryAgentStatus;
import food_delivery.model.Location;

public class DeliveryAgentRegisterRequest {
	private final String deliveryAgentId;
	private String deliveryAgentName;
	private String phoneNumber;
	private String vehicleNumber;
	private Location currentLocation;
	public DeliveryAgentRegisterRequest(String deliveryAgentId, String deliveryAgentName, String phoneNumber,
			String vehicleNumber, Location currentLocation) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.deliveryAgentName = deliveryAgentName;
		this.phoneNumber = phoneNumber;
		this.vehicleNumber = vehicleNumber;
		this.currentLocation = currentLocation;
	}
	public String getDeliveryAgentId() {
		return deliveryAgentId;
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
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
}
