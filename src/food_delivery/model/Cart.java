package food_delivery.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import food_delivery.enums.AddItemResult;
import food_delivery.exception.InvalidQuantityException;



public class Cart {

	private Integer restaurantId;
    private final List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItem() {
        return Collections.unmodifiableList(cartItems);
    }

    public AddItemResult addItemToCart(MenuItem item, int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException(quantity + " is invalid");
        }
        if(restaurantId==null) {
        	restaurantId=item.getRestaurantId();
        }
        if (!restaurantId.equals(item.getRestaurantId())) {
            return AddItemResult.DIFFERENT_RESTAURANT;
        }
        for (CartItem cartitem : cartItems) {
            if (cartitem.getMenuItem().getMenuItemId() == item.getMenuItemId()) {
                cartitem.setQuantity(cartitem.getQuantity() + quantity);
                return AddItemResult.SUCCESS;
            }
        }
        cartItems.add(new CartItem(item, quantity));
        return AddItemResult.SUCCESS;

    }

    public boolean removeItem(int menuItemId) {
    	
        boolean removed=cartItems.removeIf(m -> m.getMenuItem().getMenuItemId() == menuItemId);
        if(removed && cartItems.isEmpty()) {
        	restaurantId=null;
        }
        return removed;

    }

    public boolean updateQuantity(int menuItemId, int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException(quantity + " is invalid");
        }
        for (CartItem cartitem : cartItems) {
            if (cartitem.getMenuItem().getMenuItemId() == menuItemId) {
                cartitem.setQuantity(quantity);
                return true;
            }
        }
        return false;
    }

    public void clearCart() {
        cartItems.clear();
        restaurantId=null;

    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getMenuItem().getPrice() * item.getQuantity();

        }
        return total;
    }
    public Integer getRestaurantId() {
    	return restaurantId;
    }
    public void assignRestaurantId(Integer restaurnantId) {
    	if(restaurnantId==null) {
    	this.restaurantId=restaurnantId;
    	}
    }
    

}
