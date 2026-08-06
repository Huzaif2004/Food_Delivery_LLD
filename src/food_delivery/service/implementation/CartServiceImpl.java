package food_delivery.service.implementation;

import java.util.List;

import food_delivery.enums.AddItemResult;
import food_delivery.exception.MenuItemNotFoundException;
import food_delivery.exception.MenuItemNotFoundInCartException;
import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Cart;
import food_delivery.model.CartItem;
import food_delivery.model.Customer;
import food_delivery.model.MenuItem;
import food_delivery.repository.CustomerRepository;
import food_delivery.repository.MenuRepository;
import food_delivery.service.CartService;

public class CartServiceImpl implements CartService{
	private CustomerRepository customerRepository;
	private MenuRepository menuRepository;
	

	public CartServiceImpl(CustomerRepository customerRepository, MenuRepository menuRepository) {
		super();
		this.customerRepository = customerRepository;
		this.menuRepository = menuRepository;
	}

	@Override
	public AddItemResult addItem(int customerId, int  menuItemId, int quantity) {
		
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(()->new UserNotFoundException("User with id"+customerId+" is not found"));
		MenuItem menuItem=menuRepository.findById(menuItemId)
				.orElseThrow(()->new MenuItemNotFoundException("Menu item id"+menuItemId+" is not found"));
		Cart cart=customer.getCart();
		return cart.addItemToCart(menuItem, quantity);
		
		
		
	}

	@Override
	public void removeItem(int customerId, int menuItemId) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(()->new UserNotFoundException("User with id"+customerId+" is not found"));
		
		Cart cart=customer.getCart();
		boolean removed=cart.removeItem(menuItemId);
		if(!removed) {
			throw new MenuItemNotFoundInCartException("Menu item id"+menuItemId+" is not found in the cart");
		}
		
		
		
	}

	@Override
	public void updateQuantity(int customerId, int menuItemId, int quantity) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(()->new UserNotFoundException("User with id"+customerId+" is not found"));
		MenuItem menuItem=menuRepository.findById(menuItemId)
				.orElseThrow(()->new MenuItemNotFoundException("Menu item id"+menuItemId+" is not found"));
		Cart cart=customer.getCart();
		boolean updated=cart.updateQuantity(menuItemId, quantity);
		if(!updated) {
			throw new MenuItemNotFoundInCartException("Menu item id"+menuItemId+" is not found in the cart");
		}
		
		
	}

	@Override
	public List<CartItem> viewCartItems(int customerId) {
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(()->new UserNotFoundException("User with id"+customerId+" is not found"));
		return customer.getCart().getCartItem();
		
	}

	@Override
	public void clearCart(int customerId) {
		Customer customer=customerRepository.findById(customerId)
				.orElseThrow(()->new UserNotFoundException("User with id"+customerId+" is not found"));
		customer.getCart().clearCart();
		
	}

}
