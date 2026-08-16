package food_delivery.service;
import java.util.List;

import food_delivery.model.Order;
import food_delivery.model.Restaurant;



public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);
    Restaurant viewRestaurant(int restaurantId);
    List<Restaurant>viewAllRestaurants();
    void removeRestaurant(int restaurantId);
    List<Order> viewPendingOrders(int restaurantId);
    
    
}
