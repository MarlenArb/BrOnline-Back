package com.orange.brisaEjemplo.greeting;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.orange.brisaEjemplo.controller.GreetingController;
import com.orange.brisaEjemplo.service.GreetingService;

@WebMvcTest(GreetingController.class)
@TestPropertySource(locations = "classpath:test.properties")
public class GreetingHTTPNoServiceNoTest {

	@MockBean
	private GreetingService greetingService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void bye() throws Exception {
		final String SIN_CONTEXT_ROOT = "/bye";
		final String SALIDA = "Adios BRISA";

		when(greetingService.bye()).thenReturn(SALIDA);
		this.mockMvc.perform(get(SIN_CONTEXT_ROOT)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(SALIDA)));
	}
	
}
