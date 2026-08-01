package food_delivery.service.implementation;
import java.util.ArrayList;
import java.util.List;

import food_delivery.dto.SearchFoodResult;
import food_delivery.exception.MenuItemAlreadyExistsException;
import food_delivery.exception.RestaurantNotFoundException;
import food_delivery.model.MenuItem;
import food_delivery.model.Restaurant;
import food_delivery.repository.RestaurantRepository;
import food_delivery.service.MenuService;
public class MenuServiceImpl implements MenuService {

    private final RestaurantRepository restaurantRepository;

    public MenuServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addMenuItem(int restaurantId, long menuItemId, String name, double price, String description) {
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new RestaurantNotFoundException(
                    "Restaurant with id "
                            + restaurantId
                            + " not found.");
        }
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()->new RestaurantNotFoundException(
                "Restaurant with id "
                + restaurantId
                + " not found."));
        if (restaurant.getMenuItems().stream().anyMatch(m -> m.getMenuItemId() == menuItemId)) {
            throw new MenuItemAlreadyExistsException("Menu Item id" + menuItemId + "already exist");
        }
        restaurant.addMenuItem(menuItemId, name, price, description);
    }

    @Override
    public void removeMenuItem(int restaurantId, long menuItemId) {
        getRestaurantOrThrow(restaurantId).removeMenuItem(menuItemId);
    }

    @Override
    public List<MenuItem> viewMenu(int restaurantId) {
        return getRestaurantOrThrow(restaurantId).getMenuItems();
    }

    @Override
    public List<SearchFoodResult> searchFood(String keyword) {
        List<SearchFoodResult> result = new ArrayList<>();
        if (keyword == null || keyword.isBlank()) {
            return result;
        }

        String searchKeyword = keyword.toLowerCase();
        for (Restaurant restaurant : restaurantRepository.findAll()) {
            for (MenuItem menuItem : restaurant.getMenuItems()) {
                String menuName = menuItem.getMenuName();
                if (menuName != null && menuName.toLowerCase().contains(searchKeyword)) {
                	SearchFoodResult s=new SearchFoodResult(restaurant,menuItem);
                    result.add(s);
                }
            }
        }
        return result;
    }

    private Restaurant getRestaurantOrThrow(int restaurantId) {
        
    	return restaurantRepository.findById(restaurantId).orElseThrow(()->new RestaurantNotFoundException(
                "Restaurant with id "
                + restaurantId
                + " not found."));
    }
}
