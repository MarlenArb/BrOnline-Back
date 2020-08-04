package com.orange.brisaEjemplo.logs;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

@Service
public class CustomLogs{
	 
	
	private Logger logger = LogManager.getLogger(CustomLogs.class);
	
	public void access(String message) {
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
	
	
}
