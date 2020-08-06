package com.orange.brisaEjemplo.logs;

import com.orange.brisaEjemplo.exception.ClienteUnprocessableException;

public class LogsExample {
	 
	//@Autowired
	//private CustomLogs logger;
	 private static CustomLogs logger= new CustomLogs(LogsExample.class);
	  
	//private Logger logger = LogManager.getLogger(LogsExample.class);
	 

	public void initLogs() {
			
			try {
				logger.access("---- acceso");
				logger.error("---- error");
				logger.admon("---- admon");				
				logger.alert("---- alertas");	
				logger.activity( "---- actividad");	
				throw new ClienteUnprocessableException("88888888888888888888888888888888888888888888888888888888888888888888");
			} catch (ClienteUnprocessableException e) {

				logger.error("esto es un error",e);
			}
		
	}

}
