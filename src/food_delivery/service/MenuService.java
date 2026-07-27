package food_delivery.service;
import food_delivery.model.*;
import java.util.List;



public interface MenuService {
    void addMenuItem(int restaurantId,
                     long menuItemId,
                     String name,
                     double price,
                     String description);

    void removeMenuItem(int restaurantId,
                        long menuItemId);

    List<MenuItem> viewMenu(int restaurantId);

    List<MenuItem> searchFood(String keyword);
    
}
