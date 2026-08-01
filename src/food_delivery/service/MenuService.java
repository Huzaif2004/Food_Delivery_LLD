package food_delivery.service;
import java.util.List;

import food_delivery.dto.SearchFoodResult;
import food_delivery.model.MenuItem;



public interface MenuService {
    void addMenuItem(int restaurantId,
                     long menuItemId,
                     String name,
                     double price,
                     String description);

    void removeMenuItem(int restaurantId,
                        long menuItemId);

    List<MenuItem> viewMenu(int restaurantId);

    List<SearchFoodResult> searchFood(String keyword);
    
}
