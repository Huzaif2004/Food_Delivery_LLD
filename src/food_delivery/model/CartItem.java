package food_delivery.model;

public class CartItem {

    
    private final MenuItem menuItem;
    private int quantity;
    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }
    public int getQuantity() {
        return quantity;
    }
    void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    


    
}
