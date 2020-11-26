package br.com.rodrigo.exception;

import java.io.Serializable;
import java.util.Date;

//Esse é o modelo retornado ao cliente quando ocorrer uma Exception!
public class ExceptionResponseModelo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponseModelo(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	


	
}
