package food_delivery.model;

public class OrderItem {
	private String menuId;
	private String menuName;
	private double price;
	private int quantity;
	public OrderItem(String menuId, String menuName, double price, int quantity) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getMenuId() {
		return menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	

}
