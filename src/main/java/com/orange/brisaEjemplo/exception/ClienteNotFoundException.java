package com.orange.brisaEjemplo.exception;

import com.orange.brisaEjemplo.exception.generic.NotFoundException;

public class ClienteNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	private  static final String DESCRIPTION = "Client Not Found.";
	
	
	public ClienteNotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
