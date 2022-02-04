package mk.ukim.finki.wtshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.repository.InMemoryManufacturerRepository;
import mk.ukim.finki.wtshop.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	private final InMemoryManufacturerRepository manufacturerRepository;
	
	public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	public List<Manufacturer> findAll() {
		return this.manufacturerRepository.findAll();
	}
}
