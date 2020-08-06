package com.orange.brisaEjemplo.exception.generic;

import com.orange.brisaEjemplo.logs.CustomLogs;

public class UnprocessableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Unprocessable Exception (422)";
	
	private static CustomLogs logger= new CustomLogs();
	
	public UnprocessableException(String detail) {
		super(DESCRIPTION + ". " + detail);
		logger.error(DESCRIPTION);
		
	}
}
