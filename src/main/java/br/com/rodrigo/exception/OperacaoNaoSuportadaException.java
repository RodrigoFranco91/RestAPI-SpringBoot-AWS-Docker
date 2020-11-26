package br.com.rodrigo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Essa é a classe que cria a nossa Exception, vamos lança-la quando algo der errado!
//Nossa exception sempre retorna bad request, devido a anotation

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperacaoNaoSuportadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//Aqui estamos pegando a exception e repassando para a classe mae
	public OperacaoNaoSuportadaException(String exception) {
		super(exception);
	}

	
}
