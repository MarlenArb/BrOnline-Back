package com.orange.brisaEjemplo.logs;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.orange.brisaEjemplo.BrisaEjemploApplication;

public class LogsExample {
	
	private Logger logger = LogManager.getLogger(LogsExample.class);
	
	public void initLogs() {
		logger.log(Level.getLevel("ACCESS"),"---- acceso");
		logger.error("---- error------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		logger.log(Level.getLevel("ADMON"),"---- admon");		
		logger.warn("---- alertas");	
		logger.log(Level.getLevel("ACTIVITY"), "---- actividad");
	
	}

}
