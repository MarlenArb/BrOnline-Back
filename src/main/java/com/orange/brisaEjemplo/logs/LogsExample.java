package com.orange.brisaEjemplo.logs;



public class LogsExample  {
	 
	//@Autowired
	//private CustomLogs logger;
	 private static CustomLogs logger= new CustomLogs();
	  
	//private Logger logger = LogManager.getLogger(LogsExample.class);
	 

	public void initLogs() {
			
			try {
				logger.access("---- acceso");
				logger.error("---- error");
				logger.admon("---- admon");				
				logger.alert("---- alertas");	
				logger.activity( "---- actividad");	
				throw new Exception();
			} catch (Exception e) {

				logger.error("esto es un error",e);
			}
		
	}

}
