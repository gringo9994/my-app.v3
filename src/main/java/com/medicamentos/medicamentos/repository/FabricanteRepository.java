package com.medicamentos.medicamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicamentos.medicamentos.models.Fabricante;
@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
	
	

}
