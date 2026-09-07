package food_delivery.model;

import java.util.UUID;

import food_delivery.enums.DeliveryAgentStatus;

public class DeliveryAgent {
	private final String deliveryAgentId;
	private String deliveryAgentName;
	private String phoneNumber;
	private DeliveryAgentStatus deliveryAgentStatus;
	private double currentRating;
	private String vehicleNumber;
	private Location currentLocation;
	
	public DeliveryAgent(String deliveryAgentName, String phoneNumber,
			DeliveryAgentStatus deliveryAgentStatus, double currentRating, String vehicleNumber,
			Location currentLocation) {
		super();
		this.deliveryAgentId = UUID.randomUUID().toString();
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
	public void markAvailable() {
		if(DeliveryAgentStatus.ACTIVE==deliveryAgentStatus) {
			throw new IllegalStateException("Delivery Agent is already available");
		}
		this.deliveryAgentStatus=DeliveryAgentStatus.ACTIVE;
	}
	public void markUnavailable() {
		if(DeliveryAgentStatus.BUSY==deliveryAgentStatus) {
			throw new IllegalStateException("Delivery Agent is already in work");
		}
		this.deliveryAgentStatus=DeliveryAgentStatus.BUSY;
	}
	public void updateRating(double rating) {
		if(rating<0) {
			throw new IllegalArgumentException("Rating must be between 0 and 5");
		}
		this.currentRating=rating;
		
	}
	
    
}
