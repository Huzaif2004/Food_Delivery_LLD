package food_delivery.repository;
import java.util.List;

import food_delivery.model.Restaurant;

public interface RestaurantRepository {
	void save(Restaurant restaurant);

    Restaurant findById(int restaurantId);

    List<Restaurant> findAll();

    boolean existsById(int restaurantId);

    void deleteById(int restaurantId);


}
