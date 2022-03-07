package mk.ukim.finki.wtshop.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.wtshop.model.Category;

public interface CategoryService {
	
	List<Category> findAll();
	Optional<Category> findById(Long id);
	void deleteById(Long id);
	Optional<Category> edit(Long id, String name, String description);
	Optional<Category> save(String name, String description);

}
