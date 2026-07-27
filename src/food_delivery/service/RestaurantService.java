package food_delivery.service;
import food_delivery.model.*;
import java.util.List;



public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);
    Restaurant viewRestaurant(int restaurantId);
    List<Restaurant>viewAllRestaurants();
    void removeRestaurant(int restaurantId);
    
    
}
