package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;

public interface OrderRepository {
	void save(Order order);

    Optional<Order> findById(String orderId);

    List<Order> findAll();

    boolean existsById(String orderId);

    void deleteById(String orderId);
    
    List<Order> findByRestaurantIdAndStatus(String restaurantId, OrderStatus status);

}
