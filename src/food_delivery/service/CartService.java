package food_delivery.service;

import java.util.List;

import food_delivery.enums.AddItemResult;
import food_delivery.model.CartItem;

public interface CartService {
	AddItemResult addItem(String customerId, int menuItemId, int quantity);

	void removeItem(String customerId, int menuItemId);

	void updateQuantity(String customerId, int menuItemId, int quantity);

	List<CartItem> viewCartItems(String customerId);

	void clearCart(String customerId);
	
	void replaceCart(String customerId,int menuItemId,int quantity);

}
