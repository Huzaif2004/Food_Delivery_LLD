package food_delivery.service;

import java.util.List;
import java.util.Optional;

import food_delivery.dto.SearchFoodResult;
import food_delivery.model.MenuItem;

public interface MenuService {
	void addMenuItem(int restaurantId, int menuItemId, String name, double price, String description);

	void removeMenuItem(int menuItemId);

	List<MenuItem> findByRestaurantId(int restaurantId);

	List<SearchFoodResult> searchFood(String keyword);
	
	
	
	

}
