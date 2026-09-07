package food_delivery.service;

import food_delivery.dto.DeliveryAgentRegisterRequest;
import food_delivery.dto.DeliveryAgentResponse;
import food_delivery.dto.DeliveryAgentUpdateRequest;
import food_delivery.dto.LocationUpdateRequest;

public interface DeliveryAgentService {
	void register(DeliveryAgentRegisterRequest deliveryAgentRegisterRequest);
	DeliveryAgentResponse getProfileDetails(String deliveryAgentId);
	void updateProfile(DeliveryAgentUpdateRequest deliveryAgentUpdateRequest);
	void markAvailable(String deliveryAgentId);
	void markUnAvailable(String deliveryAgentId);
	void updateLocation(LocationUpdateRequest locationUpdateRequest);
	
	
	
	
	

}
