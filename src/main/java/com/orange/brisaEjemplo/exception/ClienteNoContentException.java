package com.orange.brisaEjemplo.exception;

import com.orange.brisaEjemplo.exception.generic.NoContentException;

public class ClienteNoContentException extends NoContentException{

	private static final long serialVersionUID = 1L;
	private  static final String DESCRIPTION = "Client No Content.";
	
	
	public ClienteNoContentException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
