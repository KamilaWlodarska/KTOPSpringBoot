package ktop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ktop.models.ProductsCategory;

@Repository
public interface ProductsCategoryRepository extends JpaRepository<ProductsCategory, Long> {

	List<ProductsCategory> findByOrderByTypeDesc();
}