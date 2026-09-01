package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.enums.OrderStatus;
import food_delivery.model.Order;
import food_delivery.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository{

	private final Map<String, Order> orders = new HashMap<>();
	@Override
    public void save(Order order) {
        orders.put(order.getOrderId(), order);
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public boolean existsById(String orderId) {
        return orders.containsKey(orderId);
    }

    @Override
    public void deleteById(String orderId) {
        orders.remove(orderId);
    }

	@Override
	public List<Order> findByRestaurantIdAndStatus(String restaurantId, OrderStatus status) {
		return orders.values().stream().filter(o->o.getRestaurantId().equals(restaurantId))
				.filter(o->o.getOrderStatus()==status).toList();
	}

}
