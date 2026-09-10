package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.model.DeliveryAgent;

public interface DeliveryAgentRepository {
	void save(DeliveryAgent deliveryAgent);
	Optional<DeliveryAgent> findById(String deliveryAgentId);
	List<DeliveryAgent>findAll();
	void updateDeliveryAgentDetails(DeliveryAgent deliveryAgent);
	void deleteById(String deliveryAgentId);
	
	

}
