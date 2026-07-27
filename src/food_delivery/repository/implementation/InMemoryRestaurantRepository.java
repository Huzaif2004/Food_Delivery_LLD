package food_delivery.repository.implementation;

import java.util.List;

import food_delivery.model.Restaurant;
import food_delivery.repository.RestaurantRepository;

public class InMemoryRestaurantRepository implements RestaurantRepository{

	@Override
	public void save(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurant findById(int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(int restaurantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(int restaurantId) {
		// TODO Auto-generated method stub
		
	}

}
