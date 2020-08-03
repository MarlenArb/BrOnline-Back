package com.orange.brisaEjemplo.exception;

public class BrisaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BrisaException(String errorMessage) {
		super(errorMessage);
	}
	
	public BrisaException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
