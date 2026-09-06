package food_delivery.dto;

import food_delivery.enums.DeliveryAgentStatus;
import food_delivery.model.Location;

public class DeliveryAgentResponse {
	private String deliveryAgentId;
	private String deliveryAgentName;
	private String deliveryAgentPhoneNumber;
	private String vehicleNumber;
	private DeliveryAgentStatus deliveryAgentStatus;
	private Location currentLocation;
	private double currentRating;
	public DeliveryAgentResponse(String deliveryAgentId, String deliveryAgentName, String deliveryAgentPhoneNumber,
			String vehicleNumber, DeliveryAgentStatus deliveryAgentStatus, Location currentLocation,
			double currentRating) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.deliveryAgentName = deliveryAgentName;
		this.deliveryAgentPhoneNumber = deliveryAgentPhoneNumber;
		this.vehicleNumber = vehicleNumber;
		this.deliveryAgentStatus = deliveryAgentStatus;
		this.currentLocation = currentLocation;
		this.currentRating = currentRating;
	}
	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}
	public String getDeliveryAgentName() {
		return deliveryAgentName;
	}
	public String getDeliveryAgentPhoneNumber() {
		return deliveryAgentPhoneNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public DeliveryAgentStatus getDeliveryAgentStatus() {
		return deliveryAgentStatus;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public double getCurrentRating() {
		return currentRating;
	}
	

}
