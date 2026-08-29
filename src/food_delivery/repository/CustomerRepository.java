package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.model.Customer;
public interface CustomerRepository {
	void save(Customer customer);

    Optional<Customer> findById(String customerId);

    List<Customer> findAll();

    boolean existsById(String customerId);

    void deleteById(String customerId);
    
    Optional<Customer> findByEmail(String email);


}
