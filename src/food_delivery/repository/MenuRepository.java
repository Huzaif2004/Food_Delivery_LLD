package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.model.MenuItem;

public interface MenuRepository {
	void add(MenuItem item);
	void removeMenuItem(String menuItemId);
	boolean existsById(String menuItemId);
	List<MenuItem>findAll();
	Optional<MenuItem> findById(String menuItemId);

}
