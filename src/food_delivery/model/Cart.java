package food_delivery.model;

import java.util.*;
import food_delivery.exception.*;



public class Cart {

    private final List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItem() {
        return Collections.unmodifiableList(cartItems);
    }

    public void addItemToCart(MenuItem item, int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException(quantity + " is invalid");
        }
        for (CartItem cartitem : cartItems) {
            if (cartitem.getMenuItem().getMenuItemId().longValue() == item.getMenuItemId().longValue()) {
                cartitem.setQuantity(cartitem.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(item, quantity));

    }

    public void removeItem(int menuItemId) {
        cartItems.removeIf(m -> m.getMenuItem().getMenuItemId().longValue() == menuItemId);

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

    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getMenuItem().getPrice() * item.getQuantity();

        }
        return total;
    }

}
