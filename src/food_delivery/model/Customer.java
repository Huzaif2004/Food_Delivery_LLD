package food_delivery.model;

import java.util.*;

public class Customer {
    private final int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;

    // Composition
    private final List<Order> orderHistory;
    private final Cart cart;

    public Customer(int customerId, String name, String phoneNumber, String email, String address, String password) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.orderHistory = new ArrayList<>();
        this.cart = new Cart();
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public Cart getCart() {
        return cart;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> viewOrderHistory() {
        return orderHistory;
    }

    public String getPassword() {
        return password;
    }

}
