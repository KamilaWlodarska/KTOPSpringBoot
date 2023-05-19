package ktop.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Homes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String home_name;
	@OneToMany(mappedBy="id")
	private List<UsersHomes> users_homes;
	@OneToMany(mappedBy="id")
	private List<ProductsCategory> pcat;
	
	public Homes() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHome_name() {
		return home_name;
	}

	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}

	public List<UsersHomes> getUsers_homes() {
		return users_homes;
	}

	public void setUsers_homes(List<UsersHomes> users_homes) {
		this.users_homes = users_homes;
	}

	public List<ProductsCategory> getPcat() {
		return pcat;
	}

	public void setPcat(List<ProductsCategory> pcat) {
		this.pcat = pcat;
	}
}