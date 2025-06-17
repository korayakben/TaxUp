package com.korayakben.taxup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.korayakben.taxup.entities.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{
	@Query(value = "SELECT * FROM client WHERE username = ?1", nativeQuery = true)
	Client getUserByUsername(String username);
}
