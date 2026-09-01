package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.model.Restaurant;
import food_delivery.repository.RestaurantRepository;

public class InMemoryRestaurantRepository implements RestaurantRepository{

	private final Map<String,Restaurant>restaurants=new HashMap<>();
	@Override
	public void save(Restaurant restaurant) {
		restaurants.put(restaurant.getRestaurantId(),restaurant);
		
		
	}

	@Override
	public Optional<Restaurant> findById(String restaurantId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(restaurants.get(restaurantId));
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(restaurants.values());
	}

	@Override
	public boolean existsById(String restaurantId) {
		// TODO Auto-generated method stub
		return restaurants.containsKey(restaurantId);
	}

	@Override
	public void deleteById(String restaurantId) {
		restaurants.remove(restaurantId);
		
	}

}
