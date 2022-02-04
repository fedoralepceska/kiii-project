package mk.ukim.finki.wtshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mk.ukim.finki.wtshop.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
	
	private final ManufacturerService manufacturerService;
	
	public ManufacturerController(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

	@GetMapping
	public String getProductsPage(Model model) {
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("bodyContent", "manufacturers");
		return "master-template";
	}
}
