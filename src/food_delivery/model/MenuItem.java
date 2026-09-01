package food_delivery.model;

import java.util.UUID;

public class MenuItem {

    private final String menuItemId;
    private String menuName;
    private double price;
    private String description;
    private final String  restaurantId;
    
    public MenuItem(String menuName, double price, String description, String restaurantId) {
        this.menuItemId = UUID.randomUUID().toString();
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.restaurantId = restaurantId;
    }
    public String getMenuItemId() {
        return menuItemId;
    }
    public String getMenuName() {
        return menuName;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getRestaurantId() {
        return restaurantId;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    

    
    
    
    
}
