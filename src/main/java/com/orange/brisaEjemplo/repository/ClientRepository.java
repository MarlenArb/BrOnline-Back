package com.orange.brisaEjemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orange.brisaEjemplo.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	public List<Client> findByName(String name);
	
	@Query(value = "SELECT * FROM clients c WHERE id%2=0 ORDER BY c.id ASC", nativeQuery = true)
	public List<Client> findByIdIsPair();
	
	public List<Client> findByNameContainingOrderByNameDesc(String filtro);
}
