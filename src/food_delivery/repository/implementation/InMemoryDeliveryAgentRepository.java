package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.model.DeliveryAgent;
import food_delivery.repository.DeliveryAgentRepository;

public class InMemoryDeliveryAgentRepository implements DeliveryAgentRepository{

	private Map<String,DeliveryAgent> deliveryAgents=new HashMap<>();
	@Override
	public void save(DeliveryAgent deliveryAgent) {
		// TODO Auto-generated method stub
		deliveryAgents.put(deliveryAgent.getDeliveryAgentId(), deliveryAgent);
		
	}

	@Override
	public Optional<DeliveryAgent> findById(String deliveryAgentId) {
		return Optional.ofNullable(deliveryAgents.get(deliveryAgentId));
		
	}

	@Override
	public List<DeliveryAgent> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(deliveryAgents.values());
	}

	@Override
	public void updateDeliveryAgentDetails(DeliveryAgent deliveryAgent) {
		deliveryAgents.put(deliveryAgent.getDeliveryAgentId(), deliveryAgent);
		
	}

}
