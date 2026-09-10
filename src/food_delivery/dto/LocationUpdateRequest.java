package food_delivery.dto;

public class LocationUpdateRequest {
	private final String deliveryAgentId;
    private final String latitude;
    private final String longitude;
	public LocationUpdateRequest(String deliveryAgentId, String latitude, String longitude) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
    

}
