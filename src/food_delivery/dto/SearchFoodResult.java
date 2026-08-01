package food_delivery.dto;

import food_delivery.model.MenuItem;
import food_delivery.model.Restaurant;

public class SearchFoodResult {
	private String restaurantName;
	private int menuId;
	private String menuName;
	private double price;
    private String description;
	public SearchFoodResult(String restaurantName, int menuId,String menuName, double price, String description) {
		super();
		this.restaurantName = restaurantName;
		this.menuId=menuId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}

	
	public int getMenuId() {
		return menuId;
	}

	

	public String getMenuName() {
		return menuName;
	}
	
	public double getPrice() {
		return price;
	}
	public String getDescrition() {
		return description;
	}

	

}
