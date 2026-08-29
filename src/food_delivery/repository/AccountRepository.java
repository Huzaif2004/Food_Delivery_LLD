package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.model.Account;

public interface AccountRepository {
	void save(Account account);

    Optional<Account> findById(int accountId);

    List<Account> findAll();

    boolean existsById(int accountId);

    void deleteById(int accountId);
    
    Optional<Account> findByEmail(String email);

}
