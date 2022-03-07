package mk.ukim.finki.wtshop.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
	
	private final CategoryService categoryService;
	
	public CategoryRestController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	
	@GetMapping
	public List<Category> findAll(){
		return this.categoryService.findAll();
	}
	
	

}
