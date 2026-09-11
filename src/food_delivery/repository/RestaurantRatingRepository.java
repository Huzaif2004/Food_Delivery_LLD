package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.model.RestaurantRating;

public interface RestaurantRatingRepository {
	void save(RestaurantRating restaurantRating);
	Optional<RestaurantRating>findById(String restaurantRatingId);
	List<RestaurantRating>findByRestaurantId(String restaurantId);
	double getAverageRatingByRestaurant(String restaurantId);

}
