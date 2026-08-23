package food_delivery.service.implementation;
import food_delivery.exception.InvalidCredentialsException;
import food_delivery.exception.UserAlreadyExistException;
import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Customer;
import food_delivery.model.Order;
import food_delivery.repository.CustomerRepository;
import food_delivery.service.CustomerService;
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public boolean addCustomer(Customer customer){
        if(customerRepository.existsById(customer.getCustomerId())){
            throw new UserAlreadyExistException("User with id"+customer.getCustomerId()+"already exist");
        }
        customerRepository.save(customer);
        return true;
    }
    public Customer login(String email,String password){
        Customer customer=customerRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("User with email "+email+" is not found"));
        if(!customer.getPassword().equals(password)){
            throw new InvalidCredentialsException("Invalid Credentials");
        }
        return customer;
        
    }
    public void updateCustomer(String email,Customer updatedCustomer){
    	Customer customer=customerRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("User with email"+email+" is not found"));
        
        customer.setName(updatedCustomer.getName());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setAddress(updatedCustomer.getAddress());
        
    }
    public Customer viewCustomer(String email){
    	Customer customer=customerRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("User with email "+email+" is not found"));
    	return customer;
    }
    public void addOrder(int customerId,Order order) {
    	Customer customer=customerRepository.findById(customerId).
    			orElseThrow(()->new UserNotFoundException("User with id "+customerId+" is not found"));
    	if(order!=null) {
    		customer.addOrder(order);
    		
    	}
    }
	
    
}
