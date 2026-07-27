package food_delivery.repository;

import java.util.List;

import food_delivery.model.Customer;
public interface CustomerRepository {
	void save(Customer customer);

    Customer findById(int customerId);

    List<Customer> findAll();

    boolean existsById(int customerId);

    void deleteById(int customerId);


}
