package mk.ukim.finki.wtshop.data;

import mk.ukim.finki.wtshop.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataHolder {
	
	public static List<Manufacturer> manufacturers = new ArrayList<>();

	//@PostConstruct
	public void init() {
//		manufacturers.add(new Manufacturer(1L, "Coca Cola", "USA"));
//		manufacturers.add(new Manufacturer(2L, "Zara", "Spain"));
//		manufacturers.add(new Manufacturer(3L, "Alibaba", "China"));
//		manufacturers.add(new Manufacturer(3L, "Toyota", "Japan"));
	}
	
}
