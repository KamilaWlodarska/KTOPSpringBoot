package ktop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktop.models.Users;
import ktop.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;
	
	public UsersService() {
		super();
	}
	
	public <S extends Users> S save(S entity) {
		return repository.save(entity);
	}
	
	public List<Users> findAll() {
		return repository.findAll();
	}
	
	public Optional<Users> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}