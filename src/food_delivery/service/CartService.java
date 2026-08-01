package food_delivery.service;

import food_delivery.model.Cart;

public interface CartService {
	void addItem(int customerId, long menuItemId, int quantity);

	void removeItem(int customerId, long menuItemId);

	void updateQuantity(int customerId, long menuItemId, int quantity);

	Cart viewCart(int customerId);

	void clearCart(int customerId);

}
