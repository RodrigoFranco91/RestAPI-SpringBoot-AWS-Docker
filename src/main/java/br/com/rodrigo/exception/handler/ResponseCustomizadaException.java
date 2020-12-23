package br.com.rodrigo.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.rodrigo.exception.ExceptionResponseModelo;
import br.com.rodrigo.exception.InvalidJwtAuthenticationException;
import br.com.rodrigo.exception.OperacaoNaoSuportadaException;
import br.com.rodrigo.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class ResponseCustomizadaException extends ResponseEntityExceptionHandler {
	
	//É Tratativa padrao de todos as exception!
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponseModelo> handleAllException(Exception ex, WebRequest req){
		ExceptionResponseModelo erm = new ExceptionResponseModelo(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(erm, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//É Tratativa da excpetion criada por nos - OperacaoNaoSuportadaException!
	@ExceptionHandler(OperacaoNaoSuportadaException.class)
	public final ResponseEntity<ExceptionResponseModelo> handleBadRequestException(Exception ex, WebRequest req){
		ExceptionResponseModelo erm = new ExceptionResponseModelo(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(erm, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponseModelo> handleNotFoundException(Exception ex, WebRequest req){
		ExceptionResponseModelo erm = new ExceptionResponseModelo(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(erm, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponseModelo> invalidJwtAuthenticationException(Exception ex, WebRequest req){
		ExceptionResponseModelo erm = new ExceptionResponseModelo(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(erm, HttpStatus.BAD_REQUEST);
	}
}
