package com.orange.brisaEjemplo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.orange.brisaEjemplo.entity.Client;
import com.orange.brisaEjemplo.repository.ClientRepository;
import com.orange.brisaEjemplo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client newClient0() {
		try {
			Client c = new Client();
			c.setName("Cliente 0");
			Client c1 = clientRepository.save(c);
			return c1;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Client newClient(Client client) {

		try {
			Client c = clientRepository.save(client);
			return c;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Optional<Client> getClientById(Long id) {
		Optional<Client> c = clientRepository.findById(id);
		return c;
	}

	@Override
	public List<Client> getClients(String name) {
		List<Client> c = clientRepository.findByName(name);
		return c;
	}

	@Override
	public List<Client> getClientsContaining(String name) {
		List<Client> c = clientRepository.findByNameContainingOrderByNameDesc(name);
		return c;
	}

	@Override
	public List<Client> getAllSort() {
		Sort sort = Sort.by("name").descending().and(Sort.by("id"));
		List<Client> c = clientRepository.findAll(sort);
		return c;
	}

	@Override
	public List<Client> getAllIdIsPair() {
		List<Client> c = clientRepository.findByIdIsPair();
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public Client updateClient(Client clientNew, Long id) {

		return clientRepository.findById(id).map(client -> {
			client.setName(clientNew.getName());
			return clientRepository.save(client);
		}).orElseGet(() -> {
			clientNew.setId(id);
			return clientRepository.save(clientNew);
		});

	}

}
