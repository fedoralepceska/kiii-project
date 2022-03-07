package mk.ukim.finki.wtshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	
	//find all categories
	
	@GetMapping
	public String getCategoryPage(Model model) {
		
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("bodyContent", "categories");
		return "master-template";
	}
	
	//add new category
	
	@GetMapping("/add-form")
	public String addCategoryPage(Model model) {
		
		model.addAttribute("bodyContent", "category-form");
		return "master-template";
	}
	
	@PostMapping
	public String addCategory(@RequestParam String name, @RequestParam String description) {
		
		this.categoryService.save(name, description);
		return "redirect:/categories";
	}
	
	//edit category
	
	@GetMapping("/edit-form/{id}")
	public String editCategoryPage(@PathVariable Long id,Model model) {
		
		Category category=this.categoryService.findById(id).get();
		model.addAttribute("category", category);
		model.addAttribute("bodyContent", "category-form");
		return "master-template";
	}
	
	@PostMapping("/{id}")
	public String editCategory(@PathVariable Long id, @RequestParam String name, @RequestParam String description) {
		
		this.categoryService.edit(id, name, description);
		return "redirect:/categories";
	}
	
	//delete category
	
	@DeleteMapping("/delete/{id}")
	public String deleteCategoryPage(@PathVariable Long id) {
		
		this.categoryService.deleteById(id);
		return "redirect:/categories";
	}
	

}
