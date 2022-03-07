package mk.ukim.finki.wtshop.data;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataHolder {
	
	public static List<Manufacturer> manufacturers = new ArrayList<>();
	public static List<Category> categories=new ArrayList<>();

	//@PostConstruct
	public void init() {
//		manufacturers.add(new Manufacturer(1L, "Coca Cola", "USA"));
//		manufacturers.add(new Manufacturer(2L, "Zara", "Spain"));
//		manufacturers.add(new Manufacturer(3L, "Fanta", "Usa"));
//		manufacturers.add(new Manufacturer(4L, "Alkaloid", "MKD"));
//      manufacturers.add(new Manufacturer(5L, "Bvlgari", "Italy"));
//		manufacturers.add(new Manufacturer(6L, "Samsung", "Korea"));
//		manufacturers.add(new Manufacturer(7L, "New Yorker", "Germany"));
	}
	
	
	//@PostConstruct
	public void initCategories() {
		//categories.add(new Category(1L,"Fashion","Clothing-Shoes-Accessories"));
		//categories.add(new Category(2L,"Electronics","Mobile-Computers&Tablets"));
		//categories.add(new Category(3L,"Supermarket","Food-Drinks-PersonalCare"));
		//categories.add(new Category(4L,"Home","Furniture-Home Decor"));
		//categories.add(new Category(5L,"Pharmacy","Drugs-Health&Beauty-Baby Care"));
		//categories.add(new Category(6L,"Beauty","Perfumes-Make up"));
	}
	
}
