package food_delivery.service.implementation;

import java.util.List;
import java.util.Optional;

import food_delivery.dto.AccountCreationRequest;
import food_delivery.enums.AccountRole;
import food_delivery.exception.AccountAlreadyExistException;
import food_delivery.exception.RestaurantNotFoundException;
import food_delivery.model.Account;
import food_delivery.model.Restaurant;
import food_delivery.repository.AccountRepository;
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
    private final AccountRepository accountRepository;
    public RestaurantServiceImpl(RestaurantRepository repository,OrderRepository orderRepository, AuthService authService, PasswordUtil passwordUtil, AccountRepository accountRepository) {
        this.repository = repository;
        this.orderRepository=orderRepository;
		this.authService = authService;
		this.passwordUtil = passwordUtil;
		this.accountRepository = accountRepository;
    }
    @Override
    public void addRestaurant(String restaurantName,String address,String email,String password) {
    	Optional<Account> existing_account = accountRepository.findByEmail(email);
	    if (existing_account.isPresent()) {
	        throw new AccountAlreadyExistException("An account already exists with email: " + email+", with role "+existing_account.get().getRole());
	    }
        Restaurant restaurant=new Restaurant(restaurantName,address);
        repository.save(restaurant);
        String hashedPassword=passwordUtil.hashPassword(password);
        try {
        	authService.register(new AccountCreationRequest(email, hashedPassword, AccountRole.RESTAURANT_ADMIN, restaurant.getRestaurantId()));
        }
        catch(Exception e) {
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
