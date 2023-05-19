package ktop.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProductsCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pcat_name;
	private String type;
	@ManyToOne
	private Homes home;
	@OneToMany(mappedBy="id")
	private List<Products> product;
	
	public ProductsCategory() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPcat_name() {
		return pcat_name;
	}
	
	public void setPcat_name(String pcat_name) {
		this.pcat_name = pcat_name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Homes getHome() {
		return home;
	}

	public void setHome(Homes home) {
		this.home = home;
	}

	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}
}