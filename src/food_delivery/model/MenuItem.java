package food_delivery.model;

public class MenuItem {

    private Long menuItemId;
    private String menuName;
    private double price;
    private String description;
    private final Restaurant restaurant;
    
    public MenuItem(Long menuItemId, String menuName, double price, String description, Restaurant restaurant) {
        this.menuItemId = menuItemId;
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }
    public Long getMenuItemId() {
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
    public Restaurant getRestaurant() {
        return restaurant;
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
    @Override
    public String toString() {
        return "MenuItem [menuItemId=" + menuItemId + ", menuName=" + menuName + ", price=" + price + ", description="
                + description + "]"+restaurant.getRestaurantId();
    }

    
    
    
    
}
