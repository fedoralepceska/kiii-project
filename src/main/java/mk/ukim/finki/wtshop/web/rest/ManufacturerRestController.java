package mk.ukim.finki.wtshop.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.service.ManufacturerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerRestController {
	
	private final ManufacturerService manufacturerService;
	
	public ManufacturerRestController(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

	@GetMapping
	public List<Manufacturer> findAll() {
		return this.manufacturerService.findAll();
	}
}
