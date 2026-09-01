package food_delivery.service;

import java.util.List;
import java.util.Optional;

import food_delivery.dto.SearchFoodResult;
import food_delivery.model.MenuItem;

public interface MenuService {
	void addMenuItem(String restaurantId, String name, double price, String description);

	void removeMenuItem(String menuItemId);

	List<MenuItem> findByRestaurantId(String restaurantId);

	List<SearchFoodResult> searchFood(String keyword);
	
	
	
	

}
