package com.orange.brisaEjemplo.greeting;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class GreetingHTTPNoTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void isAlive() throws Exception {
		final String SIN_CONTEXT_ROOT = "/";	// en mockMvc no se pone el context root: /brisa
		final String SALIDA = "Aplicacion BRISA funcionando correctamente";
		
		this.mockMvc.perform(get(SIN_CONTEXT_ROOT)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(SALIDA)));
	}
	
	@Test
	@Order(2)
	public void hello() throws Exception {
		final String SIN_CONTEXT_ROOT = "/hello";	// en mockMvc no se pone el context root: /brisa
		final String SALIDA = "Hola BRISA";
		
		this.mockMvc.perform(get(SIN_CONTEXT_ROOT)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(SALIDA)));
	}

}
