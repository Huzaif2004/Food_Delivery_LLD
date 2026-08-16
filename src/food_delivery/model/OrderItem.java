package food_delivery.model;

public class OrderItem {
	private int menuId;
	private String menuName;
	private double price;
	private int quantity;
	public OrderItem(int menuId, String menuName, double price, int quantity) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	

}
