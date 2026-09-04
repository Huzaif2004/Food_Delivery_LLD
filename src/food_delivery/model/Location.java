package food_delivery.model;

public class Location {
	private String latitude;
	private String longitude;
	public Location(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	

}
