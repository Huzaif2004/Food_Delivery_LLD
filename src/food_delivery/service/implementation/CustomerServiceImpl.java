package food_delivery.service.implementation;
import java.util.Optional;

import food_delivery.dto.AccountCreationRequest;
import food_delivery.enums.AccountRole;
import food_delivery.exception.AccountAlreadyExistException;
import food_delivery.exception.CustomerAlreadyExistException;
import food_delivery.exception.InvalidCredentialsException;
import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Customer;
import food_delivery.model.Order;
import food_delivery.repository.CustomerRepository;
import food_delivery.service.AuthService;
import food_delivery.service.CustomerService;
import food_delivery.utils.PasswordUtil;
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AuthService authService;
    private final PasswordUtil passwordUtil;
    

    public CustomerServiceImpl(CustomerRepository customerRepository, AuthService authService, PasswordUtil passwordUtil) {
		super();
		this.customerRepository = customerRepository;
		this.authService = authService;
		this.passwordUtil = passwordUtil;
	}
	public boolean addCustomer(String name,String email,String password,String phoneNumber,String address){
		Optional<Customer> existing = customerRepository.findByEmail(email);
	    if (existing.isPresent()) {
	        throw new CustomerAlreadyExistException("Customer already registered with email: " + email);
	    }
	    String hashedPassword=passwordUtil.hashPassword(password);
	    Customer customer=new Customer(name,phoneNumber,email,address,hashedPassword);
        customerRepository.save(customer);
        try {
        	authService.register(new AccountCreationRequest(customer.getEmail(), hashedPassword, AccountRole.CUSTOMER, customer.getCustomerId()));
        	
        }
        catch(AccountAlreadyExistException e) {
        	customerRepository.deleteById(customer.getCustomerId());
        	throw e;
        }
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
    public void addOrder(String customerId,Order order) {
    	Customer customer=customerRepository.findById(customerId).
    			orElseThrow(()->new UserNotFoundException("User with id "+customerId+" is not found"));
    	if(order!=null) {
    		customer.addOrder(order);
    		
    	}
    }
	
    
}
