package com.orange.brisaEjemplo.exception;

import com.orange.brisaEjemplo.exception.generic.BadRequestException;

public class ClienteBadRequestException extends BadRequestException{

	private static final long serialVersionUID = 1L;
	private  static final String DESCRIPTION = "Client Badrequest.";
	
	
	public ClienteBadRequestException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
