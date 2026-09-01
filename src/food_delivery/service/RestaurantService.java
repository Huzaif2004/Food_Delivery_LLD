package food_delivery.service;
import java.util.List;

import food_delivery.model.Order;
import food_delivery.model.Restaurant;



public interface RestaurantService {
    void addRestaurant(String restaurantName,String address,String email,String password);
    Restaurant viewRestaurant(String restaurantId);
    List<Restaurant>viewAllRestaurants();
    void removeRestaurant(String restaurantId);
    
    
    
}
