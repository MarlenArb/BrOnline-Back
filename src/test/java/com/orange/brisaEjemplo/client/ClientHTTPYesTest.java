package com.orange.brisaEjemplo.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.orange.brisaEjemplo.entity.Client;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@Sql("/sql/test-h2.sql")
@AutoConfigureTestDatabase
public class ClientHTTPYesTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	@Order(1)
	public void saveClient0() throws Exception {
		
		final String CON_CONTEXT_ROOT = "/brisa/saveClient0";
		
		Client result = this.restTemplate.getForObject("http://localhost:" + port + CON_CONTEXT_ROOT, Client.class);
		assertNotNull(result);
	}
	
}
