package food_delivery.service.implementation;

import java.util.List;

import food_delivery.dto.AccountCreationRequest;
import food_delivery.enums.AccountRole;
import food_delivery.exception.AccountAlreadyExistException;
import food_delivery.exception.RestaurantNotFoundException;
import food_delivery.model.Restaurant;
import food_delivery.repository.OrderRepository;
import food_delivery.repository.RestaurantRepository;
import food_delivery.service.AuthService;
import food_delivery.service.RestaurantService;
import food_delivery.utils.PasswordUtil;

public class RestaurantServiceImpl implements RestaurantService{


    private final RestaurantRepository repository;
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final PasswordUtil passwordUtil;

    public RestaurantServiceImpl(RestaurantRepository repository,OrderRepository orderRepository, AuthService authService, PasswordUtil passwordUtil) {
        this.repository = repository;
        this.orderRepository=orderRepository;
		this.authService = authService;
		this.passwordUtil = passwordUtil;
    }
    @Override
    public void addRestaurant(String restaurantName,String address,String email,String password) {
        Restaurant restaurant=new Restaurant(restaurantName,address);
        repository.save(restaurant);
        String hashedPassword=passwordUtil.hashPassword(password);
        try {
        	authService.register(new AccountCreationRequest(email, hashedPassword, AccountRole.RESTAURANT_ADMIN, restaurant.getRestaurantId()));
        }
        catch(AccountAlreadyExistException e) {
        	repository.deleteById(restaurant.getRestaurantId());
        	throw e;
        }
    }

    @Override
    public Restaurant viewRestaurant(String restaurantId) {
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
    public void removeRestaurant(String restaurantId) {
        if(!repository.existsById(restaurantId)){
            throw new RestaurantNotFoundException(
                    "Restaurant with id "
                    + restaurantId
                    + " not found.");
        }
        repository.deleteById(restaurantId);
    }
	
    
}
