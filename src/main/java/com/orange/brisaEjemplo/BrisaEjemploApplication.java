package com.orange.brisaEjemplo;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orange.brisaEjemplo.controller.ClientController;
import com.orange.brisaEjemplo.logs.LogsExample;

@SpringBootApplication
public class BrisaEjemploApplication {

	private static LogsExample logsExample = new LogsExample();


	public static void main(String[] args) {

		SpringApplication.run(BrisaEjemploApplication.class, args);

		logsExample.initLogs();

	}
}
