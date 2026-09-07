package food_delivery.dto;

public class LocationUpdateRequest {
	private final String deliveryAgentId;
    private final double latitude;
    private final double longitude;
	public LocationUpdateRequest(String deliveryAgentId, double latitude, double longitude) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
    

}
