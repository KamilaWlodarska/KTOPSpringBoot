package ktop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ktop.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}