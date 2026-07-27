package food_delivery.service.implementation;
import java.util.*;
import food_delivery.model.*;
import food_delivery.service.CustomerService;
import food_delivery.exception.*;
public class CustomerServiceImpl implements CustomerService {
    Map<Integer,Customer> customers=new HashMap<>();

    public boolean addCustomer(Customer customer){
        if(customers.containsKey(customer.getCustomerId())){
            throw new UserAlreadyExistException("User with id"+customer.getCustomerId()+"already exist");
        }
        customers.put(customer.getCustomerId(), customer);
        return true;
    }
    public Customer login(int customerId,String email,String password){
        Customer customer=customers.get(customerId);
        if(customer==null){
             throw new UserNotFoundException("User with id"+customerId+" is not found");
        }
        if(!customer.getEmail().equals(email) || !customer.getPassword().equals(password)){
            throw new InvalidCredentialsException("Invalid Credentials");
        }
        return customer;
        
    }
    public void updateCustomer(int customerId,Customer customer){
        if(!customers.containsKey(customerId)){
               throw new UserNotFoundException("User with id"+customerId+" is not found");
        }
        Customer cust=customers.get(customerId);
        cust.setName(customer.getName());
        cust.setPhoneNumber(customer.getPhoneNumber());
        cust.setEmail(customer.getEmail());
        cust.setAddress(customer.getAddress());
        
    }
    public Customer viewCustomer(int customerId){
        if(!customers.containsKey(customerId)){
               throw new UserNotFoundException("User with id"+customerId+" is not found");
        }
        return customers.get(customerId);
    }
    
}
