package com.orange.brisaEjemplo.service;

import java.util.List;
import java.util.Optional;

import com.orange.brisaEjemplo.entity.Client;

public interface ClientService {
	public Client newClient0();
	public Client newClient(Client client);
	public void deleteClient(Long id);
	public Client updateClient(Client clientNew, Long id);
	
	public Optional<Client> getClientById(Long id);
	public List<Client> getClients(String name);
	public List<Client> getClientsContaining(String name);
	public List<Client> getAllSort();
	public List<Client> getAllIdIsPair();
}
