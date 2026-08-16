package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;

public interface OrderRepository {
	void save(Order order);

    Optional<Order> findById(int orderId);

    List<Order> findAll();

    boolean existsById(int orderId);

    void deleteById(int orderId);
    
    List<Order> findByRestaurantIdAndStatus(int restaurantId, OrderStatus status);

}
