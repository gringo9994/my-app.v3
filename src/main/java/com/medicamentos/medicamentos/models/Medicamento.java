package com.medicamentos.medicamentos.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
@Entity

@Setter
@Getter


public class Medicamento  {

	// os dados repassados ,quando as informações não forem nulas
	@JsonInclude(Include.NON_NULL)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	
	@JsonInclude(Include.NON_NULL)
	  
	private String registro;
	
	@JsonInclude(Include.NON_NULL)

	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	

	private String validade;
	
	
	
	@JsonInclude(Include.NON_NULL)

	private Double preco;
	
	@JsonInclude(Include.NON_NULL)

	private Integer quantidade;
	
	@JsonInclude(Include.NON_NULL)
	
	
	@OneToOne(cascade = CascadeType.ALL)   //um  medicamento para um fabricante

	@JoinColumn(name = "id_fabricante")
	private Fabricante fabricante;
	
	
	@JsonInclude(Include.NON_NULL)
	// esse medicamento pode ter muitas reações
	@OneToMany(mappedBy = "medicamento")
	private List<Reacoes> reacoes;


	// construtor Vazio
	public Medicamento() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRegistro() {
		return registro;
	}


	public void setRegistro(String registro) {
		this.registro = registro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getValidade() {
		return validade;
	}


	public void setValidade(String validade) {
		this.validade = validade;
	}


	

	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


	public List<Reacoes> getReacoes() {
		return reacoes;
	}


	public void setReacoes(List<Reacoes> reacoes) {
		this.reacoes = reacoes;
	}
	
	


	
	
}

	
