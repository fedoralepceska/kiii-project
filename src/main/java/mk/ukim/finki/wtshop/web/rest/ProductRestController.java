package mk.ukim.finki.wtshop.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	@GetMapping
	public String findAll() {
		return "PRODUCTS";
	}
}
