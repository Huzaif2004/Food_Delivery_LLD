package food_delivery.model;

import java.util.UUID;

public class RestaurantRating {

	private final String restaurantRatingId;
	private String restaurantId;
	private String customerId;
	private String orderId;
	private double rating;
	private String comment;
	public RestaurantRating(String restaurantId, String customerId, String orderId,
			double rating, String comment) {
		super();
		this.restaurantRatingId = UUID.randomUUID().toString();
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.orderId = orderId;
		this.rating = rating;
		this.comment = comment;
	}
	public String getRestaurantRatingId() {
		return restaurantRatingId;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public String getOrderId() {
		return orderId;
	}
	public double getRating() {
		return rating;
	}
	public String getComment() {
		return comment;
	}
	
}
