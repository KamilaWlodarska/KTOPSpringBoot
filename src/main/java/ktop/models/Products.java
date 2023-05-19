package ktop.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ProductsCategory pcat;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purchase_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date open_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	
	public Products() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getPurchase_date() {
		return purchase_date;
	}
	
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	public Date getOpen_date() {
		return open_date;
	}
	
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public ProductsCategory getPcat() {
		return pcat;
	}

	public void setPcat(ProductsCategory pcat) {
		this.pcat = pcat;
	}
}