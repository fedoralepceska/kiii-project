package mk.ukim.finki.wtshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private List<Product> products;

	public ShoppingCart() {
		this.products = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
