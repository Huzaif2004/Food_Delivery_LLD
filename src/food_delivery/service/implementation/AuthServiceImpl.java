package food_delivery.service.implementation;

import java.util.Optional;

import food_delivery.dto.AccountCreationRequest;
import food_delivery.dto.LoginResult;
import food_delivery.exception.AccountAlreadyExistException;
import food_delivery.exception.InvalidCredentialsException;
import food_delivery.exception.UserNotFoundException;
import food_delivery.model.Account;
import food_delivery.repository.AccountRepository;
import food_delivery.service.AuthService;
import food_delivery.utils.PasswordUtil;

public class AuthServiceImpl implements AuthService{

	private final AccountRepository accountRepository;
	private final PasswordUtil passwordUtil;
	public AuthServiceImpl(AccountRepository aaccountRepository, PasswordUtil passwordUtil) {
		super();
		this.accountRepository = aaccountRepository;
		this.passwordUtil = passwordUtil;
	}

	@Override
	public LoginResult login(String email, String password) {
		Account account=accountRepository.findByEmail(email)
				.orElseThrow(()->new UserNotFoundException("User with email "+email+" not found"));
		String hashedPassword=account.getPassword();
		if(!passwordUtil.verifyPassword(password, hashedPassword)) {
			throw new InvalidCredentialsException("Invalid Password");
		}
		
		return new LoginResult(account.getAccountId(),account.getEmail(),account.getRole(),account.getAssociatedId());
	}

	@Override
	public void register(AccountCreationRequest request) {
		Optional<Account> existing = accountRepository.findByEmail(request.getEmail());
	    if (existing.isPresent()) {
	        throw new AccountAlreadyExistException("An account already exists with email: " + request.getEmail()+", with role "+existing.get().getRole());
	    }
		accountRepository.save(new Account(request.getEmail(),request.getPassword(),request.getRole(),request.getAssociatedId()));
				
		
	}

}
