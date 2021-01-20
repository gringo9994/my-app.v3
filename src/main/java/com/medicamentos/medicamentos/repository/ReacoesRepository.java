package com.medicamentos.medicamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicamentos.medicamentos.models.Reacoes;
@Repository
public interface ReacoesRepository extends JpaRepository<Reacoes, Long> {

}
