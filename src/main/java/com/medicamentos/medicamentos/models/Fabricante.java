package com.medicamentos.medicamentos.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Fabricante {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	@JsonInclude(Include.NON_NULL)
 
	private String nome;
	@JsonInclude(Include.NON_NULL)
   private String telefone;
	
	@JsonInclude(Include.NON_NULL)
	
	@JoinColumn(name = "id_medicamento")
	@OneToOne(cascade = CascadeType.ALL)
	private Medicamento medicamento;
	
	

	// contrutor vazio
	
	public Fabricante() {
		
	}
	
	





	public Fabricante(Long id, String nome, Medicamento medicamento) {
		super();
		this.id = id;
		this.nome = nome;
	
	}







	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}







	public String getTelefone() {
		return telefone;
	}







	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}







	public Medicamento getMedicamento() {
		return medicamento;
	}







	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}














	
	
	
	
	
	
	

}
