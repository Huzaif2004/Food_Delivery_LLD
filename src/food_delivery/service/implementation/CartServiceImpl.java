package food_delivery.service.implementation;

import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Cart;
import food_delivery.model.Customer;
import food_delivery.repository.CustomerRepository;
import food_delivery.service.CartService;

public class CartServiceImpl implements CartService{
	private CustomerRepository customerRepository;

	@Override
	public void addItem(int customerId, long menuItemId, int quantity) {
		
		
		
		
	}

	@Override
	public void removeItem(int customerId, long menuItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuantity(int customerId, long menuItemId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart viewCart(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearCart(int customerId) {
		// TODO Auto-generated method stub
		
	}

}
