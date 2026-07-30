package food_delivery.service;
import food_delivery.model.Customer;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    Customer login(String email,String password);
    void updateCustomer(String email,Customer customer);
    Customer viewCustomer(String email);
    
}
