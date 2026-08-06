package food_delivery.service;

import java.util.List;

import food_delivery.enums.AddItemResult;
import food_delivery.model.CartItem;

public interface CartService {
	AddItemResult addItem(int customerId, int menuItemId, int quantity);

	void removeItem(int customerId, int menuItemId);

	void updateQuantity(int customerId, int menuItemId, int quantity);

	List<CartItem> viewCartItems(int customerId);

	void clearCart(int customerId);

}
