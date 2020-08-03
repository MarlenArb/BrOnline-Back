package com.orange.brisaEjemplo.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.orange.brisaEjemplo.entity.Client;
import com.orange.brisaEjemplo.repository.ClientRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Sql("/sql/test-h2.sql")
@AutoConfigureTestDatabase
public class ClientRepositoryNoTest {

	@MockBean
	ClientRepository clientRepository;

	@Test
	@Order(1)
	public void whenFindByName_thenReturnClient() {
		// given
		Client c = new Client("Cliente Prueba");
		List<Client> list = new ArrayList<>();
		list.add(c);
		
		// when
		when(clientRepository.save(c)).thenReturn(c);
		when(clientRepository.findByName(c.getName())).thenReturn(list);

		// then
		Client cNew = clientRepository.save(c);
		assertThat(cNew.getName()).isEqualTo(c.getName());
		Client found = clientRepository.findByName(c.getName()).get(0); // el primero
		assertThat(found.getName()).isEqualTo(c.getName());
	}
	
}
