package mk.ukim.finki.wtshop.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.wtshop.model.Manufacturer;

public interface ManufacturerService {
	
	List<Manufacturer> findAll();
	
	void deleteById(Long id);
	
	Optional<Manufacturer> findById(Long id);
	
	Optional<Manufacturer> save(String name, String address);
	
	Optional<Manufacturer> edit(Long id, String name, String address);
}