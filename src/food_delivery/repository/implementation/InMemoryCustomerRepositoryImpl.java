package food_delivery.repository.implementation;

import java.util.List;

import food_delivery.model.Customer;
import food_delivery.repository.CustomerRepository;

public class InMemoryCustomerRepositoryImpl implements CustomerRepository{

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(int customerId) {
		// TODO Auto-generated method stub
		
	}

}
