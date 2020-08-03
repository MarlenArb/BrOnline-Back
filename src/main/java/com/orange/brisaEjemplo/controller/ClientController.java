package com.orange.brisaEjemplo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orange.brisaEjemplo.entity.Client;
import com.orange.brisaEjemplo.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Api(value = "ClientController")
@Tag(name = "ClientController", description = "Contralador para la tabla clients")
@RestController
@RequestMapping("/client")
public class ClientController {

	private Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;

	// ---------------------------------------------------------------- GET (select SQL)
	
	// http://localhost:8080/brisa/client/getClients/Cliente 0
	@ApiOperation(tags = "ClientController", value = "Devuelve un cliente buscado por el nombre", notes = "Descripcion detallada...")
	@RequestMapping(value = "/getClients/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClients(@PathVariable("nombre") String name) {
		logger.trace("---- ClientController.getClients(): Ini");
		List<Client> c = clientService.getClients(name);
		logger.trace("---- ClientController.getClients(): Fin");
		return ResponseEntity.ok(c);
	}

	// http://localhost:8080/brisa/client/getClientsContaining/ent
	@ApiOperation(tags = "ClientController", value = "Devuelve un cliente buscado por un trozo del nombre", notes = "Descripcion detallada...")
	@RequestMapping(value = "/getClientsContaining/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClientsContaining(@PathVariable("nombre") String name) {
		logger.trace("---- ClientController.getClientsContaining(): Ini");
		List<Client> c = clientService.getClientsContaining(name);
		logger.trace("---- ClientController.getClientsContaining(): Fin");
		return ResponseEntity.ok(c);
	}
	
	// http://localhost:8080/brisa/client/getClientsSorts
	@ApiOperation(tags = "ClientController", value = "Devuelve todos los clientes ordenados", notes = "Descripcion detallada...")
	@RequestMapping(value = "/getAllSort", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAllSort() {
		logger.trace("---- ClientController.getAllSort(): Ini");
		List<Client> c = clientService.getAllSort();
		logger.trace("---- ClientController.getAllSort(): Fin");
		return ResponseEntity.ok(c);
	}
	
	// http://localhost:8080/brisa/client/getAllIdIsPair
	@RequestMapping(value = "/getAllIdIsPair", method = RequestMethod.GET)
	@ApiOperation(tags = "ClientController", value = "Devuelve los clientes con Ids pares", notes = "Descripcion detallada...")
	public ResponseEntity<List<Client>> getAllIdIsPair() {
		logger.trace("---- ClientController.getAllIdIsPair(): Ini");
		List<Client> c = clientService.getAllIdIsPair();
		logger.trace("---- ClientController.getAllIdIsPair(): Fin");
		return ResponseEntity.ok(c);
	}
	
	// ---------------------------------------------------------------- POST (insert SQL)
	
	// http://localhost:8080/brisa/client/saveClient0
	@ApiOperation(tags = "ClientController", value = "Guarda el cliente 0", notes = "Descripcion detallada...")
	@RequestMapping(value = "/saveClient0", method = RequestMethod.POST)
	public ResponseEntity<Client> saveClient0() {
		logger.trace("---- ClientController.saveClient0(): Ini");
		Client c = clientService.newClient0();
		logger.trace("---- ClientController.saveClient0(): Fin");
		return ResponseEntity.ok(c);
	}

	/*
	 * { "name":"Cliente 1" }
	 */
	// http://localhost:8080/brisa/client/saveClient
	@ApiOperation(tags = "ClientController", value = "Guarda un cliente pasado por parametro", notes = "Descripcion detallada...")
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public ResponseEntity<Client> saveUser(@RequestBody Client c) {
		logger.trace("---- ClientController.saveUser(): Ini");
		Client c1 = clientService.newClient(c);
		logger.trace("---- ClientController.saveUser(): Fin");
		return ResponseEntity.ok(c1);
	}
	
	// ---------------------------------------------------------------- DELETE (delete SQL)
	
	// http://localhost:8080/brisa/client/deleteClient/1
	@ApiOperation(tags = "ClientController", value = "Borra un cliente por su Id", notes = "Descripcion detallada...")
	@RequestMapping(value = "/deleteClient/{idCliente}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteClient(@PathVariable("idCliente") Long id) {
		logger.trace("---- ClientController.deleteClient(): Ini");
		Optional<Client> c = clientService.getClientById(id);
		if (c.isPresent()) {
			clientService.deleteClient(id);
		}
		logger.trace("---- ClientController.deleteClient(): Fin");
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}
	
	// ---------------------------------------------------------------- PUT (update SQL)
	
	/*
	 * { "name":"Cliente Nuevo 1" }
	 */
	// http://localhost:8080/brisa/client/updateClient/1
	@ApiOperation(tags = "ClientController", value = "Actualiza un cliente por su Id", notes = "Descripcion detallada...")
	@RequestMapping(value = "/updateClient/{idCliente}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@PathVariable("idCliente") long id, @RequestBody Client c) {
		logger.trace("---- ClientController.updateClient(): Ini");
		clientService.updateClient(c, id);
		logger.trace("---- ClientController.updateClient(): Fin");
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}
	
}
