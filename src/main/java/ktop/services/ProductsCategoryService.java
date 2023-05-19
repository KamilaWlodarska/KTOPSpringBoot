package ktop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktop.models.ProductsCategory;
import ktop.repositories.ProductsCategoryRepository;

@Service
public class ProductsCategoryService {

	@Autowired
	private ProductsCategoryRepository repository;
	
	public ProductsCategoryService() {
		super();
	}
	
	public <S extends ProductsCategory> S save(S entity) {
		return repository.save(entity);
	}
	
	public List<ProductsCategory> findAll() {
		return repository.findAll();
	}
	
	public List<ProductsCategory> findAllSort() {
		return repository.findByOrderByTypeDesc();
	}
	
	public Optional<ProductsCategory> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}