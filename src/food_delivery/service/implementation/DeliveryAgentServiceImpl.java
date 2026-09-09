package food_delivery.service.implementation;

import java.util.Optional;

import food_delivery.dto.DeliveryAgentRegisterRequest;
import food_delivery.dto.DeliveryAgentResponse;
import food_delivery.dto.DeliveryAgentUpdateRequest;
import food_delivery.dto.LocationUpdateRequest;
import food_delivery.enums.AccountRole;
import food_delivery.exception.AccountAlreadyExistException;
import food_delivery.model.Account;
import food_delivery.model.DeliveryAgent;
import food_delivery.repository.AccountRepository;
import food_delivery.repository.DeliveryAgentRepository;
import food_delivery.service.DeliveryAgentService;
import food_delivery.utils.PasswordUtil;

public class DeliveryAgentServiceImpl implements DeliveryAgentService {

	private final DeliveryAgentRepository deliveryAgentRepository;
	private final AccountRepository accountRepository;
	private final PasswordUtil passwordUtil;
	public DeliveryAgentServiceImpl(DeliveryAgentRepository deliveryAgentRepository, AccountRepository accountRepository, PasswordUtil passwordUtil) {
		super();
		this.deliveryAgentRepository = deliveryAgentRepository;
		this.accountRepository = accountRepository;
		this.passwordUtil = passwordUtil;
	}

	@Override
	public void register(DeliveryAgentRegisterRequest deliveryAgentRegisterRequest) {
		Optional<Account> existing_account = accountRepository.findByEmail(deliveryAgentRegisterRequest.getEmail());
	    if (existing_account.isPresent()) {
	        throw new AccountAlreadyExistException("An account already exists with email: " + deliveryAgentRegisterRequest.getEmail()+", with role "+existing_account.get().getRole());
	    }
	    DeliveryAgent deliveryAgent=new DeliveryAgent(deliveryAgentRegisterRequest.getDeliveryAgentName(),deliveryAgentRegisterRequest.getPhoneNumber(),
	    		deliveryAgentRegisterRequest.getVehicleNumber(),deliveryAgentRegisterRequest.getCurrentLocation());
	    deliveryAgentRepository.save(deliveryAgent);
	    try {
	    	String hashedPassword=passwordUtil.hashPassword(deliveryAgentRegisterRequest.getPassword());
	 	    Account acc=new Account(deliveryAgentRegisterRequest.getEmail(), hashedPassword, AccountRole.DELIVERY_AGENT, deliveryAgent.getDeliveryAgentId());
	 	    accountRepository.save(acc);
	    }
	    catch(Exception e) {
	    	deliveryAgentRepository.deleteById(deliveryAgent.getDeliveryAgentId());
	        throw e;
	    }
	   
	    
		
	}

	@Override
	public DeliveryAgentResponse getProfileDetails(String deliveryAgentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProfile(DeliveryAgentUpdateRequest deliveryAgentUpdateRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markAvailable(String deliveryAgentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markUnAvailable(String deliveryAgentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLocation(LocationUpdateRequest locationUpdateRequest) {
		// TODO Auto-generated method stub
		
	}
	

}
