package mk.ukim.finki.wtshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wtshop.model.Manufacturer;
import mk.ukim.finki.wtshop.repository.ManufacturerRepository;
import mk.ukim.finki.wtshop.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private final ManufacturerRepository manufacturerRepository;

	public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	@Override
	public List<Manufacturer> findAll() {
		return this.manufacturerRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.manufacturerRepository.deleteById(id);
	}

	@Override
	public Optional<Manufacturer> findById(Long id) {
		return this.manufacturerRepository.findById(id);
	}

	@Override
	public Optional<Manufacturer> save(String name, String address) {
		Manufacturer manufacturer = new Manufacturer(name, address);
		return Optional.of(this.manufacturerRepository.save(manufacturer));
	}

	@Override
	public Optional<Manufacturer> edit(Long id, String name, String address) {
		Manufacturer manufacturer = this.manufacturerRepository.findById(id).get();
		manufacturer.setName(name);
		manufacturer.setAddress(address);
		return Optional.of(this.manufacturerRepository.save(manufacturer));
	}
}