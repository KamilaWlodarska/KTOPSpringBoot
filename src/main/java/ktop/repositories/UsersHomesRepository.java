package ktop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ktop.models.UsersHomes;

@Repository
public interface UsersHomesRepository extends JpaRepository<UsersHomes, Long> {

}