package food_delivery.dto;

import food_delivery.model.MenuItem;
import food_delivery.model.Restaurant;

public class SearchFoodResult {
	private Restaurant restaurant;
	private MenuItem menuItem;
	public SearchFoodResult(Restaurant restaurant, MenuItem menuItem) {
		super();
		this.restaurant = restaurant;
		this.menuItem = menuItem;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public MenuItem getMenuItem() {
		return menuItem;
	}

	

}
