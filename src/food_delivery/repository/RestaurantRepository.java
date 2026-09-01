package food_delivery.repository;
import java.util.List;
import java.util.Optional;

import food_delivery.model.Restaurant;

public interface RestaurantRepository {
	void save(Restaurant restaurant);

    Optional<Restaurant> findById(String restaurantId);

    List<Restaurant> findAll();

    boolean existsById(String restaurantId);

    void deleteById(String restaurantId);


}
