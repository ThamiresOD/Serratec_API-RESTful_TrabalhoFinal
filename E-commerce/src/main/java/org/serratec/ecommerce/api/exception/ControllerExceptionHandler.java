package org.serratec.ecommerce.api.exception;


import java.time.LocalDateTime;

import org.serratec.ecommerce.api.security.SenhaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = CpfException.class)
	protected ResponseEntity<Object> handleUniqueCpf(CpfException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro(ex.getStatus(), ex.getTitulo(), LocalDateTime.now()));
	}
	@ExceptionHandler(value = EmailException.class)
	protected ResponseEntity<Object> handleUniqueEmail(EmailException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro(ex.getStatus(), ex.getTitulo(), LocalDateTime.now()));
	}
	@ExceptionHandler(value = ClienteNotFoundException.class)
	protected ResponseEntity<Object> handleClienteNotFound(ClienteNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemErro(ex.getStatus(), ex.getTitulo(), LocalDateTime.now()));
	}
	@ExceptionHandler(value = ProdutoNotFoundException.class)
	protected ResponseEntity<Object> handleProdutoNotFound(ProdutoNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemErro(ex.getStatus(), ex.getTitulo(), LocalDateTime.now()));
	}
	@ExceptionHandler(SenhaException.class)
	protected ResponseEntity<Object> handleEmailExceptoin(SenhaException ex) {
	 return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}
}
