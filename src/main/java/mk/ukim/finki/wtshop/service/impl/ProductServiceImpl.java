package mk.ukim.finki.wtshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.model.Product;
import mk.ukim.finki.wtshop.repository.ProductRepository;
import mk.ukim.finki.wtshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	ProductServiceImpl(ProductRepository productRepository){
		
		this.productRepository = productRepository;
	
	}

	@Override
	public List<Product> findAll() {
	
		return this.productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return this.productRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
	 
		this.productRepository.deleteById(id);
	}

	@Override
	public Optional<Product> edit(Long id, String name, Double price, Integer quantity, Category category,
			Manufacturer manufacturer) {
		
		Product product = this.productRepository.findById(id).get();
		product.setCategory(category);
		product.setManufacturer(manufacturer);
		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
	
		return Optional.of(this.productRepository.save(product));
	}

	@Override
	public Optional<Product> save(String name, Double price, Integer quantity, Category category,
			Manufacturer manufacturer) {

		Product product = new Product(name, price, quantity, category, manufacturer);
		
		return Optional.of(this.productRepository.save(product));
	}

}
