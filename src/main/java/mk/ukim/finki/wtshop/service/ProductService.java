package mk.ukim.finki.wtshop.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.model.Product;

public interface ProductService {
	
	List<Product> findAll();
	Optional<Product> findById(Long id);
	void deleteById(Long id);
	Optional<Product> edit(Long id, String name, Double price, Integer quantity, Category category, Manufacturer manufacturer);
	Optional<Product> save(String name, Double price, Integer quantity, Category category, Manufacturer manufacturer);

}
