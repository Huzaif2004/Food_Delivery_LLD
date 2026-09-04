package food_delivery.model;

import food_delivery.enums.DeliveryAgentStatus;

public class DeliveryAgent {
	private final String deliveryAgentId;
	private String deliveryAgentName;
	private String phoneNumber;
	private DeliveryAgentStatus deliveryAgentStatus;
	private double currentRating;
	private String vehicleNumber;
	private Location currentLocation;
	
	public DeliveryAgent(String deliveryAgentId, String deliveryAgentName, String phoneNumber,
			DeliveryAgentStatus deliveryAgentStatus, double currentRating, String vehicleNumber,
			Location currentLocation) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.deliveryAgentName = deliveryAgentName;
		this.phoneNumber = phoneNumber;
		this.deliveryAgentStatus = deliveryAgentStatus;
		this.currentRating = currentRating;
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
	public DeliveryAgentStatus getDeliveryAgentStatus() {
		return deliveryAgentStatus;
	}
	public double getCurrentRating() {
		return currentRating;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	
    
}
