package food_delivery.service.implementation;

import java.util.List;

import food_delivery.enums.OrderStatus;
import food_delivery.exception.RestaurantAlreadyFoundException;
import food_delivery.exception.RestaurantNotFoundException;
import food_delivery.model.Order;
import food_delivery.model.Restaurant;
import food_delivery.repository.OrderRepository;
import food_delivery.repository.RestaurantRepository;
import food_delivery.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService{


    private final RestaurantRepository repository;
    private final OrderRepository orderRepository;

    public RestaurantServiceImpl(RestaurantRepository repository,OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository=orderRepository;
    }
    @Override
    public void addRestaurant(Restaurant restaurant) {
        if(repository.existsById(restaurant.getRestaurantId())){
            throw new RestaurantAlreadyFoundException("Restaurant with id"+restaurant.getRestaurantId()+"already exist");
        }
        repository.save(restaurant);
    }

    @Override
    public Restaurant viewRestaurant(int restaurantId) {
        return repository.findById(restaurantId).orElseThrow(()->
            new RestaurantNotFoundException(
                    "Restaurant with id "
                    + restaurantId
                    + " not found.")
        );
        
    }

    @Override
    public List<Restaurant> viewAllRestaurants() {
        return repository.findAll();
    }

    @Override
    public void removeRestaurant(int restaurantId) {
        if(!repository.existsById(restaurantId)){
            throw new RestaurantNotFoundException(
                    "Restaurant with id "
                    + restaurantId
                    + " not found.");
        }
        repository.deleteById(restaurantId);
    }
	@Override
	public List<Order> viewPendingOrders(int restaurantId) {
		return orderRepository.findByRestaurantIdAndStatus(restaurantId, OrderStatus.CONFIRMED);
		
	}
    
}
