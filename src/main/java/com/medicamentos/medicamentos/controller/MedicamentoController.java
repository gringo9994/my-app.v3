package com.medicamentos.medicamentos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.medicamentos.medicamentos.repository.FabricanteRepository;
import com.medicamentos.medicamentos.repository.MedicamentoRepository;
import com.medicamentos.medicamentos.repository.ReacoesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/medicamentos")
@Api(value = "API REST MEDICAMENTOS")
@RestController
public class MedicamentoController {

	// permite que spring procura alguma implementação para essa interface
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	@Autowired
	private FabricanteRepository fabricanteRepository;

	@Autowired
	private ReacoesRepository reacoesRepository;

//	@Autowired
	// private ReacoesRepository reacoesRepository;

// Request metodo GET ,buscar informações

	@RequestMapping(method = RequestMethod.GET)

	@ApiOperation(value = "RETORNA UMA LISTA DE MEDICAMENTOS")
	public List<Medicamento> listar() {
		// Reacoes reacoes=(Reacoes) reacoesRepository.findAll();

		return medicamentoRepository.findAll();

	}

	/*
	 * criando metodo Salvar
	 * 
	 * Request metodo POST ,enviar informações para banco
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "SALVAR MEDICAMENTOS")
	public void salvar(@RequestBody Medicamento medicamento) {
		// @RequestBody PEGA INSFORMAÇOES VINDA DA REQUISIÇÃO E COLOCA NO OBJETO
		// medicamento

		Fabricante fabricante = fabricanteRepository.findById(medicamento.getFabricante().getId()).orElseThrow();

		medicamento.setFabricante(fabricante);

		medicamentoRepository.save(medicamento);
		// persiste automaticamente a entidade MEDDICAMENTO

	}

	// METODO DE BUSCAR MEDICAMENTO PELO ID

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	// tratamento de resposta
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "BUSCAR MEDICAMENTO POR ID")
	public ResponseEntity<Medicamento> buscar(@Validated @PathVariable("id") Long id) {

		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);

		if (medicamento.isEmpty()) {

			// caso não encontrar dado retorna mensagem 404
			return ResponseEntity.notFound().build();
		}
		// SE VARIAVEL MEDICAMENTO FOR IGUAL A NULL

		// RESPONSE ENTITY

		// caso obter resposta ,retorna status 200 ok
		return ResponseEntity.ok(medicamento.get());

	}

	// METODO DELETAR MEDICAMENTO PELO ID

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "DELETAR MEDICAMENTOS PELO ID")
	public void deletar(@PathVariable("id") Long id) {

		medicamentoRepository.deleteById(id);

	}

	// METODO ATUALIZAR MEDICAMENTO PELO ID

	@ApiOperation(value = "ATUALIZAR MEDICAMENTO PELO ID")

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void atualizar(@Validated @RequestBody Medicamento medicamento, @PathVariable("id") Long id) {

		/*
		 * @RequestBody PEGA INSFORMAÇOES VINDA DA REQUISIÇÃO E COLOCA NO OBJETO
		 * medicamento para atualizar no banco pelo ID
		 */
		medicamento.setId(id);

		// atualizando dados
		medicamentoRepository.save(medicamento);

	}

}
