package com.orange.brisaEjemplo.exception;

import com.orange.brisaEjemplo.exception.generic.UnprocessableException;

public class ClienteUnprocessableException extends UnprocessableException{

	private static final long serialVersionUID = 1L;
	private  static final String DESCRIPTION = "Client Unprocesable.";
	
	
	public ClienteUnprocessableException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
