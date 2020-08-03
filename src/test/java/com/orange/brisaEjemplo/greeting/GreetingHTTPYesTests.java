package com.orange.brisaEjemplo.greeting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import com.orange.brisaEjemplo.controller.GreetingController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class GreetingHTTPYesTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private GreetingController controller;

	@Test
	@Order(1)
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	@Order(2)
	public void isAlive() throws Exception {
		final String CON_CONTEXT_ROOT = "/brisa";
		final String SALIDA = "Aplicacion BRISA funcionando correctamente";

		String result = this.restTemplate.getForObject("http://localhost:" + port + CON_CONTEXT_ROOT, String.class);
		assertThat(result).contains(SALIDA);
	}

	@Test
	@Order(3)
	public void hello() throws Exception {
		final String CON_CONTEXT_ROOT = "/brisa/hello";
		final String SALIDA = "Hola BRISA";

		String result = this.restTemplate.getForObject("http://localhost:" + port + CON_CONTEXT_ROOT, String.class);
		assertThat(result).contains(SALIDA);
	}

	@Test
	@Order(4)
	public void bay() throws Exception {
		final String conContextRoot = "/brisa/bye";
		final String salida = "Adios BRISA";

		String result = this.restTemplate.getForObject("http://localhost:" + port + conContextRoot, String.class);
		assertThat(result).contains(salida);
	}
	
}
