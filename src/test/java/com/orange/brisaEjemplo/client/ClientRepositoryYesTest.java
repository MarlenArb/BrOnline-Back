package com.orange.brisaEjemplo.client;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.orange.brisaEjemplo.logs.CustomLogs;
import com.orange.brisaEjemplo.repository.ClientRepository;
import com.orange.brisaEjemplo.service.ClientService;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Sql("/sql/test-h2.sql")
@AutoConfigureTestDatabase
public class ClientRepositoryYesTest {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	private ClientService clientService;
	
	 private static CustomLogs logger= new CustomLogs();
	
	@Test
	@Order(1)
	public void addClients() throws Exception {
		List<Client> c = clientService.getAllSort();
		assertEquals(3, c.size());
	}
	
	@Test
	@Order(2)
	public void whenFindByName_thenReturnClient() {
		// given
		Client c = new Client("Client Test 1");
		clientRepository.save(c);

		// when
		Client found = clientRepository.findByName(c.getName()).get(0); // el primero

		// then
		assertThat(found.getName()).isEqualTo(c.getName());
	}
	
}
