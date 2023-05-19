package ktop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ktop.models.Homes;

@Repository
public interface HomesRepository extends JpaRepository<Homes, Long> {
	
}