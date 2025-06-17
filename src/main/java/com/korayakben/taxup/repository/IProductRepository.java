package com.korayakben.taxup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.korayakben.taxup.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "SELECT * FROM product WHERE client_id = ?1", nativeQuery = true)
	List<Product> getClientBooks(Long client_id);
	
}
