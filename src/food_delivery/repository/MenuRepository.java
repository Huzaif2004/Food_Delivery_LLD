package food_delivery.repository;

import java.util.List;
import java.util.Optional;

import food_delivery.model.MenuItem;

public interface MenuRepository {
	void add(MenuItem item);
	void removeMenuItem(int menuItemId);
	boolean existsById(int menuItemId);
	List<MenuItem>findAll();
	Optional<MenuItem> findById(int menuItemId);

}
