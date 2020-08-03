package com.orange.brisaEjemplo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orange.brisaEjemplo.controller.ClientController;

@SpringBootApplication
public class BrisaEjemploApplication {

	private static Logger logger = LogManager.getLogger(BrisaEjemploApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BrisaEjemploApplication.class, args);
		logger.info("---- ClientController.getClients(): Ini");
		logger.error("---- ClientController.getClients(): Ini");
		System.out.println("Mandale----------------------------------------------");
	}
	
}
