package food_delivery.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private final int restaurantId;
    private String restaurantName;
    private double rating;
    private String address;
    private final List<MenuItem> menuItems;

    public Restaurant(int restaurantId, String restaurantName, double rating, String address) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.address = address;
        this.menuItems = new ArrayList<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public double getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public List<MenuItem> getMenuItems() {
        return Collections.unmodifiableList(menuItems);
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.rating = rating;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addMenuItem(Long id, String menuName, double price, String description) {

        MenuItem menuItem = new MenuItem(id, menuName, price, description, this);
        menuItems.add(menuItem);

    }

    public void removeMenuItem(long menuItemId) {
        menuItems.removeIf(m -> m.getMenuItemId() == menuItemId);
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", rating=" + rating
                + ", address=" + address + ", menuItems=" + menuItems + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + restaurantId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurant other = (Restaurant) obj;
        if (restaurantId != other.restaurantId)
            return false;
        return true;
    }

}
