package com.orange.brisaEjemplo.exception.generic;

public class NoContentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "No Content Exception (204)";
	
	public NoContentException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
