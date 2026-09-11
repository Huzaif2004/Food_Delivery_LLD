package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.model.RestaurantRating;
import food_delivery.repository.RestaurantRatingRepository;

public class RestaurantRatingRepositoryImpl implements RestaurantRatingRepository{

	private Map<String,RestaurantRating>restaurantRatings=new HashMap<>();
	@Override
	public void save(RestaurantRating restaurantRating) {
		// TODO Auto-generated method stub
		restaurantRatings.put(restaurantRating.getRestaurantRatingId(), restaurantRating);
		
	}

	@Override
	public Optional<RestaurantRating> findById(String restaurantRatingId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(restaurantRatings.get(restaurantRatingId));
	}

	@Override
	public List<RestaurantRating> findByRestaurantId(String restaurantId) {
		
		return new ArrayList<>(restaurantRatings.values().stream().filter(r->r.getRestaurantId().equals(restaurantId)).toList());
	}

	@Override
	public double getAverageRatingByRestaurant(String restaurantId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
