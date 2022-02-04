package mk.ukim.finki.wtshop.model;

import lombok.Data;

@Data
public class Manufacturer {

	private Long id;

	private String name;
	
	private String address;
	
	public Manufacturer() {
	}
	
	public Manufacturer(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
