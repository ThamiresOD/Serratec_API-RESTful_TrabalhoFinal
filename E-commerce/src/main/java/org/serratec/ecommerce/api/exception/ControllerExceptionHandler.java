package org.serratec.ecommerce.api.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = UniqueCpfException.class)
	protected ResponseEntity<Object> handleUniqueCpf(UniqueCpfException ex){

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro(ex.getStatus(), ex.getTitulo(), LocalDateTime.now()));
	}
	
	protected ResponseEntity<Object> handleUniqueEmail(UniqueEmailException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro(ex.getStatus(), ex.getTitulo(), LocalDateTime.now()));
	}
	
	
}
