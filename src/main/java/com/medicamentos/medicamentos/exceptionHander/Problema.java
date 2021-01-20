package com.medicamentos.medicamentos.exceptionHander;

import java.time.LocalDate;

public class Problema {
	
	private Integer status;
	private LocalDate dataHora;
	private String titulo;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDate getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
	

}
