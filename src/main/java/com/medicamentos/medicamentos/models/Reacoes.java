package com.medicamentos.medicamentos.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Reacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonInclude(Include.NON_NULL)
	private Long id;
	@JsonInclude(Include.NON_NULL)
	 
	private String descricao;
	 
	
	
	//muitas reacoes para um medicamento
	
     @ManyToOne()
	
	@JsonIgnore

	@JoinColumn(name = "id_medicamento")
	private Medicamento medicamento;
	
	
	// contrutor vazio
	
	public Reacoes() {
		
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Medicamento getMedicamento() {
		return medicamento;
	}



	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}



	
	
	
	
	
	

}
