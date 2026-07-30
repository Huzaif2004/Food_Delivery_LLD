package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.model.Customer;
import food_delivery.repository.CustomerRepository;

public class InMemoryCustomerRepositoryImpl implements CustomerRepository{

	Map<Integer,Customer>customers=new HashMap<>();
	@Override
	public void save(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
		
	}

	@Override
	public Optional<Customer> findById(int customerId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(customers.get(customerId));
		
	}

	@Override
	public List<Customer> findAll() {
		
		List<Customer> customer_list=new ArrayList<>();
		
		customers.forEach((key,value)->customer_list.add(value));
		return customer_list;
	}

	@Override
	public boolean existsById(int customerId) {
		// TODO Auto-generated method stub
		return customers.containsKey(customerId);
	}

	@Override
	public void deleteById(int customerId) {
		customers.remove(customerId);
		
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
		
		return customers.values().stream().filter(c->c.getEmail().equals(email)).findFirst();
	}

}
