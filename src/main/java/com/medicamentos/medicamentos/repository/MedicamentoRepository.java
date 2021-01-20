package com.medicamentos.medicamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicamentos.medicamentos.controller.MedicamentoController;
import com.medicamentos.medicamentos.models.Fabricante;
import com.medicamentos.medicamentos.models.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {


	



	

}
