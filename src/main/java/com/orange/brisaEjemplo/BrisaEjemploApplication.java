package com.orange.brisaEjemplo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orange.brisaEjemplo.logs.LogsExample;

@SpringBootApplication
public class BrisaEjemploApplication {

	private static LogsExample logsExample = new LogsExample();


	public static void main(String[] args) {

		SpringApplication.run(BrisaEjemploApplication.class, args);

		logsExample.initLogs();

	}
}
