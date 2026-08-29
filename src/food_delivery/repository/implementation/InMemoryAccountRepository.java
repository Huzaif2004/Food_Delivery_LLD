package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.model.Account;
import food_delivery.repository.AccountRepository;

public class InMemoryAccountRepository implements AccountRepository{

	private Map<String,Account>accounts=new HashMap<>();
	@Override
	public void save(Account account) {
		accounts.put(account.getAccountId(), account);
		
	}

	@Override
	public Optional<Account> findById(int accountId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(accounts.get(accountId));
	}

	@Override
	public List<Account> findAll() {
		return new ArrayList<>(accounts.values());
	}

	@Override
	public boolean existsById(int accountId) {
		return accounts.containsKey(accountId);
	}

	@Override
	public void deleteById(int accountId) {
		accounts.remove(accountId);
		
	}

	@Override
	public Optional<Account> findByEmail(String email) {
		return accounts.values().stream().filter(acc->acc.getEmail().equals(email)).findFirst();
	}

}
