package food_delivery.service;

public interface RestaurantRatingService {
	void addRating(String restaurantId,String customerId,String orderId,double rating);
	void addRating(String restaurantId,String customerId,String orderId,double rating,String comment);

}
