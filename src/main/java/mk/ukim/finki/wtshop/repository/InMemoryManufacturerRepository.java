package mk.ukim.finki.wtshop.repository;

import mk.ukim.finki.wtshop.data.DataHolder;
import mk.ukim.finki.wtshop.model.Manufacturer;

import java.util.List;

//@Repository
public class InMemoryManufacturerRepository {

	public List<Manufacturer> findAll() {
		return DataHolder.manufacturers;
	}
}
