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
import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.model.Product;
import mk.ukim.finki.wtshop.service.CategoryService;
import mk.ukim.finki.wtshop.service.ManufacturerService;
import mk.ukim.finki.wtshop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	private final ManufacturerService manufacturerService;
	
	public ProductController(ProductService productService, CategoryService categoryService, ManufacturerService manufacturerService) {
		this.productService=productService;
		this.categoryService = categoryService;
		this.manufacturerService = manufacturerService;
		
	}
	

		
	@GetMapping
	public String getProductPage(Model model) {
		
		model.addAttribute("products", productService.findAll());
		model.addAttribute("bodyContent", "products");
		return "master-template";
	}
	
	
	@GetMapping("/add-form")
	public String addProductPage(Model model) {
		
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("bodyContent", "product-form");
		
		return "master-template";
	}
	
	@PostMapping //String name, Double price, Integer quantity, Category category, Manufacturer manufacturer
	public String addProduct(@RequestParam String name, @RequestParam Double price, @RequestParam Integer quantity, @RequestParam Category category, @RequestParam Manufacturer manufacturer) {
		
		this.productService.save(name, price, quantity, category, manufacturer);
		return "redirect:/products";
	}
	
	
	@GetMapping("/edit-form/{id}")
	public String editProductPage(@PathVariable Long id,Model model) {
		
		Product product = this.productService.findById(id).get();
		model.addAttribute("product", product);
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("bodyContent", "product-form");
		return "master-template";
	}
	
	@PostMapping("/{id}")
	public String editProduct(@PathVariable Long id, @RequestParam String name, @RequestParam Double price, @RequestParam Integer quantity, @RequestParam Category category, @RequestParam Manufacturer manufacturer) {
		
		this.productService.edit(id, name, price, quantity, category, manufacturer);
		return "redirect:/products";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteProductPage(@PathVariable Long id) {
		
		this.productService.deleteById(id);
		return "redirect:/products";
	}
	

}

