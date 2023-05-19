package ktop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ktop.models.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

	List<Products> findByOrderByDeadlineAsc();
}
