package ktop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktop.models.Homes;
import ktop.repositories.HomesRepository;

@Service
public class HomesService {

	@Autowired
	private HomesRepository repository;
	
	public HomesService() {
		super();
	}
	
	public <S extends Homes> S save(S entity) {
		return repository.save(entity);
	}
	
	public List<Homes> findAll() {
		return repository.findAll();
	}
	
	public Optional<Homes> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}