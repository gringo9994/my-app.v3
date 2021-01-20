package com.medicamentos.medicamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medicamentos.medicamentos.models.Fabricante;
import com.medicamentos.medicamentos.models.Medicamento;
import com.medicamentos.medicamentos.repository.FabricanteRepository;
import com.medicamentos.medicamentos.repository.MedicamentoRepository;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medicamentos.medicamentos.models.Fabricante;
import com.medicamentos.medicamentos.models.Medicamento;
import com.medicamentos.medicamentos.models.Reacoes;
import com.medicamentos.medicamentos.repository.FabricanteRepository;
import com.medicamentos.medicamentos.repository.MedicamentoRepository;
import com.medicamentos.medicamentos.repository.ReacoesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "API REST MEDICAMENTOS-Fabricante")
@RestController
@RequestMapping("/fabricante")
public class ControllerFabricante {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@ApiOperation(value = "RETORNA UMA LISTA DE FABRICANTE")
	

	// Request metodo GET ,buscar informações
	@ResponseStatus(HttpStatus.ACCEPTED)
		@RequestMapping(method = RequestMethod.GET)
		public List<Fabricante> listar() {

		
			 

			return fabricanteRepository.findAll();

		}
	
	
	

	// Request metodo POST ,Gravar  informações
	 @ApiOperation(value = "SALVAR FABRICANTE")
	
		@ResponseStatus(HttpStatus.CREATED)
		@RequestMapping( method = RequestMethod.POST)
		public void salvar(@Validated      @RequestBody Fabricante fabricante) {
			
			fabricanteRepository.save(fabricante);
			
			
			
			
		}
		
		
		

		// Request metodo PUT ,Atualizar  informações


	 @ApiOperation(value = "ATUALIZAR FABRICANTE PELO ID")
	 
		@ResponseStatus(HttpStatus.OK)

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public void atualizar(@Validated    @RequestBody Fabricante fabricante ,@PathVariable("id") Long id) {
			
			fabricante.setId(id);
			
			
			fabricanteRepository.save(fabricante);
			
		}
		
	
	 @ApiOperation(value = "DELETAR FABRICANTE PELO ID")
	 
		

		// Request metodo DELETE  ,DElETAR informações
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remover(@Validated   @PathVariable("id") Long id) {
			
			fabricanteRepository.deleteById(id);
			
		}
		
		
		
	
	

}
