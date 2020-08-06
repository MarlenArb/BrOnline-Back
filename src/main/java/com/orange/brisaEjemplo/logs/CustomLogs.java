package com.orange.brisaEjemplo.logs;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

@Service
public class CustomLogs{
	
	public Logger logger = LogManager.getLogger();
	
	
	public CustomLogs() {
	}
	
	
	public CustomLogs(Class<?> myClass) {
		logger = LogManager.getLogger(myClass);
		
	}


	public void  access(String message) {
		logger.log(Level.getLevel("ACCESS"),message);	
	}
	
	public void activity(String message) {
		logger.log(Level.getLevel("ACTIVITY"),message);	
	}
	
	public void admon(String message) {
		logger.log(Level.getLevel("ADMON"),message);	
	}
	
	public void alert(String message) {
		logger.warn(message);	
	}
	
	public void error(String message) {
		logger.error(message);	
	}
	
	public void error(String message ,Exception error) {
		logger.error(message,error);	
	}
	
	public void error(Exception error) {
		logger.error(error);	
	}
	
}
