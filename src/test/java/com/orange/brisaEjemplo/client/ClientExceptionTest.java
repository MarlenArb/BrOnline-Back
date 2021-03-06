package com.orange.brisaEjemplo.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.orange.brisaEjemplo.entity.Client;
import com.orange.brisaEjemplo.exception.ClienteBadRequestException;
import com.orange.brisaEjemplo.exception.ClienteNoContentException;
import com.orange.brisaEjemplo.exception.ClienteNotFoundException;
import com.orange.brisaEjemplo.exception.ClienteUnprocessableException;
import com.orange.brisaEjemplo.logs.CustomLogs;
import com.orange.brisaEjemplo.service.ClientService;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Sql("/sql/test-h2.sql")
@AutoConfigureTestDatabase
public class ClientExceptionTest {

	private static CustomLogs logger = new CustomLogs(ClientExceptionTest.class);

	@Autowired
	private ClientService clientService;

	@Test
	@Order(1)
	public void makingErrors() throws Exception {

		// Testing Unprocessable Exception
		try {
			throw new ClienteUnprocessableException(
					"------------------------------------------------------------------------------------");

		} catch (ClienteUnprocessableException e) {
			logger.error(e);
		}

		// Testing Not Found Exception
		try {
			throw new ClienteNotFoundException(
					"------------------------------------------------------------------------------------");

		} catch (ClienteNotFoundException e) {
			logger.error(e);
		}
		
		// Testing No Content Exception
		try {
			throw new ClienteNoContentException(
					"------------------------------------------------------------------------------------");

		} catch (ClienteNoContentException e) {
			logger.error(e);
		}
		
		
		// Testing BadRequest Exception
		try {
			throw new ClienteBadRequestException(
					"------------------------------------------------------------------------------------");

		} catch (ClienteBadRequestException e) {
			logger.error(e);
		}

	}

}
