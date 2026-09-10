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
			String vehicleNumber,
			Location currentLocation) {
		super();
		this.deliveryAgentId = UUID.randomUUID().toString();
		this.deliveryAgentName = deliveryAgentName;
		this.phoneNumber = phoneNumber;
		this.deliveryAgentStatus = DeliveryAgentStatus.ACTIVE;
		this.currentRating = 5;
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
		if(rating<0||rating>5) {
			throw new IllegalArgumentException("Rating must be between 0 and 5");
		}
		this.currentRating=rating;
		
	}
	public void updateLocation(String latitude,String longitude) {
		if (this.currentLocation == null) {
	        this.currentLocation = new Location(latitude, longitude); 
		}
		if(latitude==null||longitude==null) {
			throw new IllegalArgumentException("Both latitude and longitude shouldn't be null");
		}
		currentLocation.updateLatitude(latitude);
		currentLocation.updateLongitude(longitude);
	}
	public void updatePhoneNumber(String phoneNumber) {
		if(phoneNumber==null||phoneNumber.length()!=10||!(phoneNumber.startsWith("7")||!phoneNumber.startsWith("8")||!phoneNumber.startsWith("9"))) {
			throw new IllegalArgumentException("Invalid Phone Number");
			
		}
		this.phoneNumber=phoneNumber;
	}
	public void updateName(String deliveryAgentName) {
		if(deliveryAgentName==null) {
			throw new IllegalArgumentException("Name shouldn't be null");
		}
		this.deliveryAgentName=deliveryAgentName;
	}
	public void updateVehicleNumber(String vehicleNumber) {
		
		if(vehicleNumber==null||!vehicleNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{1,3}[0-9]{4}$")) {
			throw new IllegalArgumentException("Invalid Vehicle Number");
		}
		this.vehicleNumber=vehicleNumber;
	}
    
}
