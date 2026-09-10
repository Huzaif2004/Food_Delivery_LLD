package food_delivery.service.implementation;

import java.util.Optional;

import food_delivery.dto.DeliveryAgentRegisterRequest;
import food_delivery.dto.DeliveryAgentResponse;
import food_delivery.dto.DeliveryAgentUpdateRequest;
import food_delivery.dto.LocationUpdateRequest;
import food_delivery.enums.AccountRole;
import food_delivery.exception.AccountAlreadyExistException;
import food_delivery.exception.DeliveryAgentNotFoundException;
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
		String phoneNumber=deliveryAgentRegisterRequest.getPhoneNumber();
		if(phoneNumber==null||phoneNumber.length()!=10||!(phoneNumber.startsWith("7")||!phoneNumber.startsWith("8")||!phoneNumber.startsWith("9"))){
			throw new IllegalArgumentException("Invalid Phone Number");
			
		}
		String vehicleNumber=deliveryAgentRegisterRequest.getVehicleNumber();
		if(!vehicleNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{1,3}[0-9]{4}$")) {
			throw new IllegalArgumentException("Invalid Vehicle Number");
		}
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
		DeliveryAgent deliveryAgent=deliveryAgentRepository.findById(deliveryAgentId).
				orElseThrow(()->new DeliveryAgentNotFoundException("Delivery agent with given id: "+deliveryAgentId+"is not found"));
		return new DeliveryAgentResponse(deliveryAgent.getDeliveryAgentId(),
				deliveryAgent.getDeliveryAgentName(),deliveryAgent.getPhoneNumber(),deliveryAgent.getVehicleNumber(),
				deliveryAgent.getDeliveryAgentStatus(),deliveryAgent.getCurrentLocation(),deliveryAgent.getCurrentRating());
		
	}

	@Override
	public void updateProfile(DeliveryAgentUpdateRequest deliveryAgentUpdateRequest) {
		DeliveryAgent deliveryAgent=deliveryAgentRepository.findById(deliveryAgentUpdateRequest.getDeliveryAgentId()).
				orElseThrow(()->new DeliveryAgentNotFoundException("Delivery agent with given id: "+deliveryAgentUpdateRequest.getDeliveryAgentId()+"is not found"));
		deliveryAgent.updatePhoneNumber(deliveryAgentUpdateRequest.getPhoneNumber());
		deliveryAgent.updateName(deliveryAgentUpdateRequest.getDeliveryAgentName());
		deliveryAgent.updateVehicleNumber(deliveryAgentUpdateRequest.getVehicleNumber());
		
	}

	@Override
	public void markAvailable(String deliveryAgentId) {
		DeliveryAgent deliveryAgent=deliveryAgentRepository.findById(deliveryAgentId).
				orElseThrow(()->new DeliveryAgentNotFoundException("Delivery agent with given id: "+deliveryAgentId+"is not found"));
		deliveryAgent.markAvailable();
		
	}

	@Override
	public void markUnAvailable(String deliveryAgentId) {
		// TODO Auto-generated method stub
		DeliveryAgent deliveryAgent=deliveryAgentRepository.findById(deliveryAgentId).
				orElseThrow(()->new DeliveryAgentNotFoundException("Delivery agent with given id: "+deliveryAgentId+"is not found"));
		deliveryAgent.markUnavailable();
		
	}

	@Override
	public void updateLocation(LocationUpdateRequest locationUpdateRequest) {
		// TODO Auto-generated method stub
		DeliveryAgent deliveryAgent=deliveryAgentRepository.findById(locationUpdateRequest.getDeliveryAgentId()).
				orElseThrow(()->new DeliveryAgentNotFoundException("Delivery agent with given id: "+locationUpdateRequest.getDeliveryAgentId()+"is not found"));
		deliveryAgent.updateLocation(locationUpdateRequest.getLatitude(), locationUpdateRequest.getLongitude());
		
		
	}
	

}
