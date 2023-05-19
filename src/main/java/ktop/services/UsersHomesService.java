package ktop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktop.models.UsersHomes;
import ktop.repositories.UsersHomesRepository;

@Service
public class UsersHomesService {

	@Autowired
	private UsersHomesRepository repository;
	
	public UsersHomesService() {
		super();
	}
	
	public <S extends UsersHomes> S save(S entity) {
		return repository.save(entity);
	}
	
	public List<UsersHomes> findAll() {
		return repository.findAll();
	}
	
	public Optional<UsersHomes> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}