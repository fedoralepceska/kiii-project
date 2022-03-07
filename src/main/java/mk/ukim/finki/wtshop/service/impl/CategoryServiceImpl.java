package mk.ukim.finki.wtshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.repository.CategoryRepository;
import mk.ukim.finki.wtshop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}
	
	@Override
	public Optional<Category> findById(Long id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.categoryRepository.deleteById(id);
		
	}
	
	@Override
	public Optional<Category> edit(Long id, String name, String description) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepository.findById(id).get();
		category.setName(name);
		category.setDescription(description);
		return Optional.of(this.categoryRepository.save(category));
	}
	
	@Override
	public Optional<Category> save(String name, String description) {
		// TODO Auto-generated method stub
		Category category=new Category(name, description);
		return Optional.of(this.categoryRepository.save(category));
		
	}
	
	

}
