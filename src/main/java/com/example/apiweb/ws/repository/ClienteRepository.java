package com.example.apiweb.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiweb.ws.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
}
