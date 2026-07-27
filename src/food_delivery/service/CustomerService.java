package food_delivery.service;
import food_delivery.model.Customer;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    Customer login(int customerId,String email,String password);
    void updateCustomer(int customerId,Customer customer);
    Customer viewCustomer(int customerId);
    
}
