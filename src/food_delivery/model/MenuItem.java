package food_delivery.model;

public class MenuItem {

    private final int menuItemId;
    private String menuName;
    private double price;
    private String description;
    private final int  restaurantId;
    
    public MenuItem(int menuItemId, String menuName, double price, String description, int restaurantId) {
        this.menuItemId = menuItemId;
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.restaurantId = restaurantId;
    }
    public int getMenuItemId() {
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
    public int getRestaurantId() {
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
