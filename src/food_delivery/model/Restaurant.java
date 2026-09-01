package food_delivery.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    private final String restaurantId;
    private String restaurantName;
    private double rating;
    private String address;
    

    public Restaurant(String restaurantName, String address) {
        this.restaurantId = UUID.randomUUID().toString();
        this.restaurantName = restaurantName;
        this.rating = 5;
        this.address = address;
    }

    public String getRestaurantId() {
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

    

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", rating=" + rating
                + ", address=" + address +  "]";
    }

    
}
