package ktop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktop.models.Products;
import ktop.repositories.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository repository;
	
	public ProductsService() {
		super();
	}
	
	public <S extends Products> S save(S entity) {
		return repository.save(entity);
	}
	
	public List<Products> findAll() {
		return repository.findAll();
	}
	
	public List<Products> findAllSort() {
		return repository.findByOrderByDeadlineAsc();
	}
	
	public Optional<Products> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}