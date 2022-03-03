package mk.ukim.finki.wtshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.service.ManufacturerService;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

	private final ManufacturerService manufacturerService;

	public ManufacturerController(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

	@GetMapping
	public String getManufacturersPage(Model model) {
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("bodyContent", "manufacturers");
		return "master-template";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteManufacturer(@PathVariable Long id) {
		this.manufacturerService.deleteById(id);
		return "redirect:/manufacturers";
	}

	@GetMapping("/add-form")
	public String addManufacturerPage(Model model) {
		model.addAttribute("bodyContent", "manufacturer-form");
		return "master-template";
	}

	@GetMapping("/edit-form/{id}")
	public String addManufacturerPage(@PathVariable Long id, Model model) {
		Manufacturer manufacturer = this.manufacturerService.findById(id).get();
		model.addAttribute("manufacturer", manufacturer);
		model.addAttribute("bodyContent", "manufacturer-form");
		return "master-template";
	}

	@PostMapping
	public String addManufacturer(@RequestParam String name, @RequestParam String address) {
		this.manufacturerService.save(name, address);
		return "redirect:/manufacturers";
	}

	@PostMapping("/{id}")
	public String editManufacturer(@PathVariable Long id, @RequestParam String name, @RequestParam String address) {
		this.manufacturerService.edit(id, name, address);
		return "redirect:/manufacturers";
	}
}
