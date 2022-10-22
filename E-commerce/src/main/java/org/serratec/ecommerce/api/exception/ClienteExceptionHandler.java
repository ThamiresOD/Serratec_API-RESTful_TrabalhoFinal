package org.serratec.ecommerce.api.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClienteExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value = UniqueCpfException.class)
	protected ResponseEntity<Object> handleUniqueCpf(Exception ex, HttpHeaders headers,
			HttpStatus status, WebRequest request){
		UniqueCpfException cpfException = new UniqueCpfException(status.value(), "Esse cpf já existe!",
				LocalDateTime.now());
		return handleExceptionInternal(ex,cpfException, headers, status, request);
	}
}
