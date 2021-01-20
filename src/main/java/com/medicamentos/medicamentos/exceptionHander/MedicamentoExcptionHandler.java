package com.medicamentos.medicamentos.exceptionHander;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice


// TRATAMENTO DE ERROS DO CLIENTE (NAVEGADOR)
public class MedicamentoExcptionHandler extends  ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var problema=new Problema();
		problema.setStatus(status.value());
		problema.setTitulo("Alguns campos Preenchidos Incorretos, Verifique espaços,campos em branco,etc.");
		
		problema.setDataHora(LocalDate.now());
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
	
	
	

}