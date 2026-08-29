package food_delivery.service;
import food_delivery.model.Customer;
import food_delivery.model.Order;

public interface CustomerService {
    boolean addCustomer(String name,String email,String password,String phoneNumber,String address);
    Customer login(String email,String password);
    void updateCustomer(String email,Customer customer);
    Customer viewCustomer(String email);
    void addOrder(String customerId,Order order);
    
}
