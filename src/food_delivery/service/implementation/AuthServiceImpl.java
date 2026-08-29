package food_delivery.service.implementation;

import java.util.Optional;

import food_delivery.dto.AccountCreationRequest;
import food_delivery.dto.LoginResult;
import food_delivery.model.Account;
import food_delivery.repository.AccountRepository;
import food_delivery.service.AuthService;

public class AuthServiceImpl implements AuthService{

	private final AccountRepository accountRepository;
	
	public AuthServiceImpl(AccountRepository aaccountRepository) {
		super();
		this.accountRepository = aaccountRepository;
	}

	@Override
	public LoginResult login(String email, String password) {
		return null;
	}

	@Override
	public void register(AccountCreationRequest request) {
		Optional<Account>exists=accountRepository.findByEmail(request.getEmail());
		if(exists.isPresent()) {
			
		}
		accountRepository.save(new Account(request.getEmail(),request.getPassword(),request.getRole(),request.getAssociatedId()));
				
		
	}

}
