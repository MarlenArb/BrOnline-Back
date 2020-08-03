package com.orange.brisaEjemplo.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.orange.brisaEjemplo.entity.Client;
import com.orange.brisaEjemplo.repository.ClientRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class ClientHTTPNoServiceYesRepositoryNoTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ClientRepository clientRepository;
	
	@Test
	@Order(1)
	public void findByName() throws Exception {
		final String SIN_CONTEXT_ROOT = "/client/getClients/Cliente Prueba";	// en mockMvc no se pone el context root: /brisa

		final String CLIENTE = "Cliente Prueba";
		
		// given
		Client c = new Client(CLIENTE);
		List<Client> list = new ArrayList<>();
		list.add(c);
		
		// when
		when(clientRepository.findByName(c.getName())).thenReturn(list);
		String found = list.get(0).getName();
				
		// then
		this.mockMvc.perform(get(SIN_CONTEXT_ROOT)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(CLIENTE)));
		assertThat(found).isEqualTo(CLIENTE);
	}
}
