package food_delivery.service.implementation;

import java.util.ArrayList;
import java.util.List;

import food_delivery.dto.SearchFoodResult;
import food_delivery.exception.MenuItemAlreadyExistsException;
import food_delivery.exception.MenuItemNotFoundException;
import food_delivery.exception.RestaurantNotFoundException;
import food_delivery.model.MenuItem;
import food_delivery.model.Restaurant;
import food_delivery.repository.MenuRepository;
import food_delivery.repository.RestaurantRepository;
import food_delivery.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private final RestaurantRepository restaurantRepository;
	private final MenuRepository menuRepository;

	public MenuServiceImpl(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
		this.restaurantRepository = restaurantRepository;
		this.menuRepository = menuRepository;
	}

	@Override
	public void addMenuItem(String restaurantId, String name, double price, String description) {
		if (!restaurantRepository.existsById(restaurantId)) {
			throw new RestaurantNotFoundException("Restaurant with id " + restaurantId + " not found.");
		}
		
		MenuItem item = new MenuItem(name, price, description, restaurantId);
		menuRepository.add(item);

	}

	@Override
	public void removeMenuItem(String menuItemId) {
		if (!menuRepository.existsById(menuItemId)) {
			throw new MenuItemNotFoundException("Menu item with id " + menuItemId + " not present");
		}
		menuRepository.removeMenuItem(menuItemId);

	}

	@Override
	public List<MenuItem> findByRestaurantId(String restaurantId) {
		if (!restaurantRepository.existsById(restaurantId)) {
			throw new RestaurantNotFoundException("Restaurant with id " + restaurantId + " not found.");
		}
		
		List<MenuItem> result=menuRepository.findAll().stream().filter(m->m.getRestaurantId().equals(restaurantId)).toList();
		return result;
	}

	@Override
	public List<SearchFoodResult> searchFood(String keyword) {
		List<SearchFoodResult> result = new ArrayList<>();
		if (keyword == null || keyword.isBlank()) {
			return result;
		}

		String searchKeyword = keyword.toLowerCase();
		List<MenuItem> menuItems = menuRepository.findAll();
		for (MenuItem menuItem : menuItems) {
			String menuName = menuItem.getMenuName();
			if (menuName != null && menuName.toLowerCase().contains(searchKeyword)) {
				Restaurant restaurant=restaurantRepository.findById(menuItem.getRestaurantId()).
						orElseThrow(()->new RestaurantNotFoundException("Restaurant with id " + menuItem.getRestaurantId() + " not found.") );
				SearchFoodResult s = new SearchFoodResult(restaurant.getRestaurantName(),menuItem.getMenuItemId(), menuItem.getMenuName(),
						menuItem.getPrice(), menuItem.getDescription());
				result.add(s);
			}
		}
	    return result;

	}

	private Restaurant getRestaurantOrThrow(String restaurantId) {

		return restaurantRepository.findById(restaurantId).orElseThrow(
				() -> new RestaurantNotFoundException("Restaurant with id " + restaurantId + " not found."));
	}
}
