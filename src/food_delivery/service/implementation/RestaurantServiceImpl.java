package food_delivery.service.implementation;

import java.util.List;

import food_delivery.exception.RestaurantAlreadyFoundException;
import food_delivery.exception.RestaurantNotFoundException;
import food_delivery.model.Restaurant;
import food_delivery.repository.RestaurantRepository;
import food_delivery.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService{


    private final RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
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
        Restaurant restaurant=repository.findById(restaurantId).orElseThrow(()->
            new RestaurantNotFoundException(
                    "Restaurant with id "
                    + restaurantId
                    + " not found.")
        );
        return restaurant;
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
    
}
