package com.medicamentos.medicamentos.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medicamentos.medicamentos.models.Fabricante;
import com.medicamentos.medicamentos.models.Medicamento;
import com.medicamentos.medicamentos.models.Reacoes;
import com.medicamentos.medicamentos.repository.MedicamentoRepository;
import com.medicamentos.medicamentos.repository.ReacoesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "API REST MEDICAMENTOS-Reacoes_Adversas")
@RestController
@RequestMapping("/reacoesAdversas")
public class ControllerReacoes {

	@Autowired
	private ReacoesRepository reacoesRepository;

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	
//Request metodo GET ,buscar informações
	
	
	@ApiOperation(value = "RETORNA UMA LISTA DE REAÇÕES")
	
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( method = RequestMethod.GET)
	public List<Reacoes> listar() {

		return reacoesRepository.findAll();

	}
	
	
	

	// Request metodo POST ,Gravar  informações
	
	
	 @ApiOperation(value = "SALVAR REAÇÕES ADVERSAS DO MEDICAMENTO")
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( method = RequestMethod.POST)
	public void salvar(@RequestBody Reacoes reacoes) {
		 
		// Medicamento medicamento=medicamentoRepository.findById(reacoes.getMedicamento().getId()).orElseThrow(); 
			
	  //    reacoes.setMedicamento(medicamento);
		 
		 
		 
		 
		reacoesRepository.save(reacoes);

	}
	
	

	// Request metodo PUT ,Atualizar  informações
	 
	 
	 

	 @ApiOperation(value = "ATUALIZAR REAÇÕES PELO ID")

	@ResponseStatus(HttpStatus.OK)

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void atualizar(@Validated  @RequestBody Reacoes reacoes ,@PathVariable("id") Long id) {
		
		reacoes.setId(id);
		
		
		reacoesRepository.save(reacoes);
		
	}
	

	
	 

	 @ApiOperation(value = "DELETAR REAÇÕES PELO ID")
	 

	// Request metodo DELETE  ,DElETAR informações
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
public void remover(@PathVariable("id") Long id) {
		
		reacoesRepository.deleteById(id);
		
	}
	
	
	

}
