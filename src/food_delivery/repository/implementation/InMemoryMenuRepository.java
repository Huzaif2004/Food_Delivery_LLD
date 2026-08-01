package food_delivery.repository.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import food_delivery.model.MenuItem;
import food_delivery.repository.MenuRepository;

public class InMemoryMenuRepository implements MenuRepository{
	private Map<Integer,MenuItem> menuItems=new HashMap<>();

	@Override
	public void add(MenuItem item) {
		menuItems.put(item.getMenuItemId(), item);
		
	}

	@Override
	public void removeMenuItem(int menuItemId) {
		menuItems.remove(menuItemId);
		
	}

	@Override
	public boolean existsById(int menuItemId) {
		return menuItems.containsKey(menuItemId);
	}

	@Override
	public List<MenuItem> findAll() {
		return new ArrayList<>(menuItems.values());
	}

	@Override
	public Optional<MenuItem> findById(int menuItemId) {
		return Optional.ofNullable(menuItems.get(menuItemId));
	}

}
